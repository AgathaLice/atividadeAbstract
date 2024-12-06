package londrinaMoney;

import java.util.Scanner;
import java.util.ArrayList;

public class ContaPoupanca extends Contas{
    protected int quantidadeSaques; // Usado em limites da conta poupança
    protected int quantidadeTranferencias; // Usado em limites da conta poupança
    protected int quantidadeExtratos; // Usado em limites da conta poupança
    protected double transferencia; // Utilizado no setter em uma transferência, infelizmente não consegui testar :(

    public ContaPoupanca(String documentoRG, String documentoCPF, String comprovanteResidencia, int idade) {
        this.documentoRG = documentoRG; // Não é utilizado, mas decidi adicionar
        this.documentoCPF = documentoCPF; // Não é utilizado, mas decidi adicionar
        this.comprovanteResidencia = comprovanteResidencia; // Não é utilizado, mas decidi adicionar
        this.idade = idade; // Não é utilizado, mas decidi adicionar
        this.dinheiro = 0; // Utilizado em todas as funções pois isso é o dinheiro no banco
        this.extrato = new ArrayList<>(); // Lista mutável para adicionar os dados ao extrato
        this.quantidadeSaques = 0;
        this.quantidadeTranferencias = 0;
        this.quantidadeExtratos = 0;
    }

    ContaPoupanca contaPoup = new ContaPoupanca("456", "111.111.111-00",
            "Conta de Água", 21);
    // Eu precisava ter isso em todas as abas para os setters funcionarem, não consegui entender o porquê
    ContaCorrente contaCorr = new ContaCorrente("123", "000.000.000-00",
            "Conta de Luz", 19, "Salário");

    @Override
    public void efetuarSaque() {
        if (this.dinheiro >= 0) { // Verifica se tem dinheiro na conta
            if (this.quantidadeSaques < 2) { // Verifica se o usuário já não fez dois saques (supostamente esse mês...)
                Scanner input2 = new Scanner(System.in); // Inicia o scanner
                System.out.println("Insira o valor a ser sacado: ");
                double verificarDinheiro = input2.nextDouble(); // Input do usuário de quanto ele quer sacar
                if (verificarDinheiro <= this.dinheiro) { // Verifica se tem dinheiro o bastante na conta
                    this.dinheiro -= verificarDinheiro; // Faz o saque (supostamente o dinheiro é dado ao usuário na vida real...)
                    String dinheiroExtrato = String.valueOf(this.dinheiro);// Traduz o dinheiro atual para String para incluir no extrato
                    extrato.add("Foram sacados R$" + dinheiroExtrato); // Adiciona o saque ao extrato
                    this.quantidadeSaques += 1; // Incrementa a quantidade de saques já feitos
                } else { // Caso não há dinheiro o bastante
                    System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                            " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
                }
            } else { // Caso ultrapassou da quantidade de saques (supondo que estou contando os meses...)
                System.out.println("Você não consegue sacar dinheiro, pois já " +
                        "ultrapassou da quantidade de saques desse mês.");
            }
        } else { // Caso não há dinheiro o bastante
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void efetuarDeposito() {
        Scanner input2 = new Scanner(System.in); // Inicia o scanner
        System.out.println("Insira o valor a ser depositado: ");
        this.dinheiro += input2.nextDouble(); // Input do usuário de quanto ele quer depositar
        String dinheiroExtrato = String.valueOf(this.dinheiro); // Traduz o dinheiro atual para String para incluir no extrato
        extrato.add("Foram depositados R$" + dinheiroExtrato); // Adiciona o depósito ao extrato
    }

    @Override
    public void efetuarTransferencia() {
        if (this.dinheiro >= 0) { // Verifica se tem dinheiro na conta
            if (this.quantidadeTranferencias < 2) { // Verifica se o usuário já não fez duas transferências (supostamente esse mês...)
                Scanner input2 = new Scanner(System.in); // Inicia o scanner
                System.out.println("Insira o valor a ser transferido: ");
                double verificarDinheiro = input2.nextDouble(); // Input do usuário de quanto ele quer transferir
                if (verificarDinheiro <= this.dinheiro) { // Verifica se tem dinheiro o bastante na conta
                    this.dinheiro -= verificarDinheiro; // Remove o dinheiro da transferência de quem a faz
                    transferencia = contaCorr.getDinheiro() + verificarDinheiro; // Valor que a outra conta vai se tornar por um setter (não consegui fazer funcionar :( )
                    String dinheiroExtrato = String.valueOf(this.dinheiro); // Traduz o dinheiro atual para String para incluir no extrato
                    extrato.add("Foram transferidos R$" + dinheiroExtrato); // Adiciona a transferência ao extrato
                    contaCorr.setDinheiro(transferencia); // Em teoria, adicionaria o valor a outra conta
                    this.quantidadeTranferencias += 1;  // Incrementa a quantidade de tranferências (supostamente do mês...)
                } else { // Caso não há dinheiro o bastante
                    System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                            " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
                }
            } else { // Caso ultrapassou da quantidade de saques (do mês...)
                System.out.println("Você não consegue sacar dinheiro, pois já " +
                        "ultrapassou da quantidade de saques desse mês.");
            }
        } else { // Caso não há dinheiro o bastante
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void tirarExtrato() {
        if (this.quantidadeExtratos < 2) { // Verifica se o usuário já não retirou dois extratos (supostamente esse mês...)
            System.out.println(this.extrato); // Printa o extrato
            this.quantidadeExtratos += 1; // Incrementa a quantidade de extratos
        } else { // Limita a quantidade de extratos (por mês...)
            System.out.println("Você não consegue tirar um extrato, pois já " +
                    "ultrapassou da quantidade de pedidos desse mês.");
        }
    }

    @Override
    public double getDinheiro() {
        return this.dinheiro;
    }

    @Override
    public void setDinheiro(double transacao){ // Supostamente faria parte da transferência...
        this.dinheiro = transacao;
    }

    @Override
    public ArrayList<String> getExtrato() {
        return this.extrato;
    }

    @Override
    public int getIdade() {
        return this.idade;
    }

    @Override
    public String getComprovanteResidencia() {
        return this.comprovanteResidencia;
    }

    @Override
    public String getDocumentoCPF() {
        return this.documentoCPF;
    }

    @Override
    public String getDocumentoRG() {
        return this.documentoRG;
    }
}

package londrinaMoney;
import java.util.Scanner;
import java.util.ArrayList;

public class ContaCorrente extends Contas{
    protected String comprovanteRenda; // Não é utilizado, mas decidi adicionar
    protected double transferencia; // Utilizado no setter em uma transferência, infelizmente não consegui testar :(

    public ContaCorrente(String documentoRG, String documentoCPF, String comprovanteResidencia, int idade, String comprovanteRenda){
        this.documentoRG = documentoRG; // Não é utilizado, mas decidi adicionar
        this.documentoCPF = documentoCPF; // Não é utilizado, mas decidi adicionar
        this.comprovanteResidencia = comprovanteResidencia; // Não é utilizado, mas decidi adicionar
        this.idade = idade; // Não é utilizado, mas decidi adicionar
        this.dinheiro = 0; // Utilizado em todas as funções pois isso é o dinheiro no banco
        this.comprovanteRenda = comprovanteRenda; // Não é utilizado, mas decidi adicionar
        this.extrato = new ArrayList<>(); // Lista mutável para adicionar os dados ao extrato
    }

    ContaPoupanca contaPoup = new ContaPoupanca("456", "111.111.111-00",
            "Conta de Água", 21);
    // Eu precisava ter isso em todas as abas para os setters funcionarem, não consegui entender o porquê
    ContaCorrente contaCorr = new ContaCorrente("123", "000.000.000-00",
            "Conta de Luz", 19, "Salário");

    @Override
    public void efetuarSaque() {
        if (this.dinheiro >= 0) { // Verifica se tem dinheiro na conta
            Scanner input2 = new Scanner(System.in); // Inicia o scanner
            System.out.println("Insira o valor a ser sacado: ");
            double verificarDinheiro = input2.nextDouble(); // Input do usuário de quanto ele quer sacar
            if (verificarDinheiro <= this.dinheiro) { // Verifica se tem dinheiro o bastante na conta
                this.dinheiro -= verificarDinheiro; // Faz o saque (supostamente o dinheiro é dado ao usuário na vida real...)
                String dinheiroExtrato = String.valueOf(this.dinheiro); // Traduz o dinheiro atual para String para incluir no extrato
                extrato.add("Foram sacados R$" + dinheiroExtrato); // Adiciona o saque ao extrato
            } else { // Caso não há dinheiro o bastante
                System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                        " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
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
            Scanner input2 = new Scanner(System.in); // Inicia o scanner
            System.out.println("Insira o valor a ser transferido: ");
            double verificarDinheiro = input2.nextDouble(); // Input do usuário de quanto ele quer transferir
            if (verificarDinheiro <= this.dinheiro) { // Verifica se tem dinheiro o bastante na conta
                this.dinheiro -= verificarDinheiro; // Remove o dinheiro da transferência de quem a faz
                transferencia = contaPoup.getDinheiro() + verificarDinheiro; // Valor que a outra conta vai se tornar por um setter (não consegui fazer funcionar :( )
                String dinheiroExtrato = String.valueOf(this.dinheiro); // Traduz o dinheiro atual para String para incluir no extrato
                extrato.add("Foram transferidos R$" + dinheiroExtrato); // Adiciona a transferência ao extrato
                contaPoup.setDinheiro(transferencia); // Em teoria, adicionaria o valor a outra conta
            } else { // Caso não há dinheiro o bastante
                System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                        " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
            }
        } else { // Caso não há dinheiro o bastante
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void tirarExtrato() { // Printa o extrato
        System.out.println(this.extrato);
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

package londrinaMoney;
import java.util.Scanner;
import java.util.ArrayList;

public class ContaCorrente extends Contas{
    protected String comprovanteRenda;
    protected double transferencia;

    public ContaCorrente(String documentoRG, String documentoCPF, String comprovanteResidencia, int idade, String comprovanteRenda){
        this.documentoRG = documentoRG;
        this.documentoCPF = documentoCPF;
        this.comprovanteResidencia = comprovanteResidencia;
        this.idade = idade;
        this.dinheiro = 0;
        this.comprovanteRenda = comprovanteRenda;
        this.extrato = new ArrayList<>();
    }

    ContaPoupanca contaPoup = new ContaPoupanca("456", "111.111.111-00", "Conta de Água", 21);
    ContaCorrente contaCorr = new ContaCorrente("123", "000.000.000-00", "Conta de Luz", 19, "Salário");

    @Override
    public void efetuarSaque() {
        if (this.dinheiro >= 0) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Insira o valor a ser sacado: ");
            double verificarDinheiro = input2.nextDouble();
            if (verificarDinheiro <= this.dinheiro) {
                this.dinheiro -= verificarDinheiro;
                String dinheiroExtrato = String.valueOf(this.dinheiro);
                extrato.add("Foram sacados R$" + dinheiroExtrato);
            } else {
                System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                        " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
            }
        } else {
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void efetuarDeposito() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Insira o valor a ser depositado: ");
        this.dinheiro = input2.nextDouble();
        String dinheiroExtrato = String.valueOf(this.dinheiro);
        extrato.add("Foram depositados R$" + dinheiroExtrato);
    }

    @Override
    public void efetuarTransferencia() {
        if (this.dinheiro >= 0) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("Insira o valor a ser transferido: ");
            double verificarDinheiro = input2.nextDouble();
            if (verificarDinheiro <= this.dinheiro) {
                double transacao = contaPoup.getDinheiro();
                this.dinheiro -= verificarDinheiro;
                transferencia = contaPoup.getDinheiro() + verificarDinheiro;
                String dinheiroExtrato = String.valueOf(this.dinheiro);
                extrato.add("Foram transferidos R$" + dinheiroExtrato);
                contaPoup.setDinheiro(transferencia);
            } else {
                System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                        " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
            }
        } else {
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void tirarExtrato() {
        System.out.println(this.extrato);
    }

    @Override
    public double getDinheiro() {
        return this.dinheiro;
    }

    @Override
    public void setDinheiro(double transacao){
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

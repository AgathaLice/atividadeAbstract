package londrinaMoney;
import java.util.Scanner;
import java.util.ArrayList;

public class ContaCorrente extends Contas{
    protected String comprovanteRenda;

    public ContaCorrente(String documentoRG, String documentoCPF, String comprovanteResidencia, int idade, String comprovanteRenda){
        this.documentoRG = documentoRG;
        this.documentoCPF = documentoCPF;
        this.comprovanteResidencia = comprovanteResidencia;
        this.idade = idade;
        this.dinheiro = 0;
        this.comprovanteRenda = comprovanteRenda;
        this.extrato = new ArrayList<>();
    }

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

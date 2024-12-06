package londrinaMoney;

import java.util.Scanner;
import java.util.ArrayList;

public class ContaPoupanca extends Contas{
    protected int quantidadeSaques;
    protected int quantidadeTranferencias;
    protected int quantidadeExtratos;

    public ContaPoupanca(String documentoRG, String documentoCPF, String comprovanteResidencia, int idade) {
        this.documentoRG = documentoRG;
        this.documentoCPF = documentoCPF;
        this.comprovanteResidencia = comprovanteResidencia;
        this.idade = idade;
        this.dinheiro = 0;
        this.extrato = new ArrayList<>();
        this.quantidadeSaques = 0;
        this.quantidadeTranferencias = 0;
        this.quantidadeExtratos = 0;
    }

    @Override
    public void efetuarSaque() {
        if (this.dinheiro >= 0) {
            if (quantidadeSaques < 2) {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Insira o valor a ser sacado: ");
                double verificarDinheiro = input2.nextDouble();
                if (verificarDinheiro <= this.dinheiro) {
                    this.dinheiro -= verificarDinheiro;
                    String dinheiroExtrato = String.valueOf(this.dinheiro);
                    extrato.add("Foram sacados R$" + dinheiroExtrato);
                    quantidadeSaques += 1;
                } else {
                    System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                            " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
                }
            } else {
                System.out.println("Você não consegue sacar dinheiro, pois já " +
                        "ultrapassou da quantidade de saques desse mês.");
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
            if (quantidadeTranferencias < 2) {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Insira o valor a ser transferido: ");
                double verificarDinheiro = input2.nextDouble();
                if (verificarDinheiro <= this.dinheiro) {
                    this.dinheiro -= verificarDinheiro;
                    String dinheiroExtrato = String.valueOf(this.dinheiro);
                    extrato.add("Foram transferidos R$" + dinheiroExtrato);
                    quantidadeTranferencias += 1;
                } else {
                    System.out.println("Você não consegue sacar essa quantidade de dinheiro," +
                            " não há o bastante na conta. Você têm: R$" + String.valueOf(this.dinheiro));
                }
            } else {
                System.out.println("Você não consegue sacar dinheiro, pois já " +
                        "ultrapassou da quantidade de saques desse mês.");
            }
        } else {
            System.out.println("Você não consegue sacar essa quantidade de dinheiro, você não tem nada na conta");
        }
    }

    @Override
    public void tirarExtrato() {
        if (quantidadeExtratos < 2) {
            System.out.println(this.extrato);
        } else {
            System.out.println("Você não consegue tirar um extrato, pois já " +
                    "ultrapassou da quantidade de pedidos desse mês.");
        }
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

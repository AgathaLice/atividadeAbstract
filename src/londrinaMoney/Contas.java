package londrinaMoney;

import java.util.ArrayList;
// A tal classe abstrata
public abstract class Contas {
    protected String documentoRG; // Não é utilizado, mas decidi adicionar
    protected String documentoCPF; // Não é utilizado, mas decidi adicionar
    protected String comprovanteResidencia; // Não é utilizado, mas decidi adicionar
    protected double dinheiro; // Criação do dinheiro em comum entre as clases
    protected int idade; // Não é utilizado, mas decidi adicionar
    protected ArrayList<String> extrato; // Criação do extrato, comum entre as classes

    // Criação do esqueleto de cada metodo, que sera utilizado depois
    public abstract void efetuarSaque();

    public abstract void efetuarDeposito();

    public abstract void efetuarTransferencia();

    public abstract void tirarExtrato();

    public abstract double getDinheiro();

    public abstract void setDinheiro(double transacao);

    public abstract ArrayList<String> getExtrato();

    public abstract int getIdade();

    public abstract String getComprovanteResidencia();

    public abstract String getDocumentoCPF();

    public abstract String getDocumentoRG();
}

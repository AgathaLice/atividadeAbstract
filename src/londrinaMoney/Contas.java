package londrinaMoney;

import java.util.ArrayList;

public abstract class Contas {
    protected String documentoRG;
    protected String documentoCPF;
    protected String comprovanteResidencia;
    protected double dinheiro;
    protected int idade;
    protected ArrayList<String> extrato;

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

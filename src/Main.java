import londrinaMoney.ContaCorrente;
import londrinaMoney.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorr = new ContaCorrente("123", "000.000.000-00", "Conta de Luz", 19, "Salário");

        System.out.println(contaCorr.getDocumentoCPF());
        contaCorr.efetuarDeposito();
        System.out.println(contaCorr.getDinheiro());
        contaCorr.efetuarSaque();
        System.out.println(contaCorr.getDinheiro());
        contaCorr.tirarExtrato();
    }
}
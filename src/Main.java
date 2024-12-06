import londrinaMoney.ContaCorrente;
import londrinaMoney.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorr = new ContaCorrente("123", "000.000.000-00", "Conta de Luz", 19, "Salário");
        ContaPoupanca contaPoup = new ContaPoupanca("456", "111.111.111-00", "Conta de Água", 21);

        System.out.println(contaCorr.getDocumentoCPF());
        contaCorr.efetuarDeposito();
        System.out.println(contaCorr.getDinheiro());
        contaCorr.efetuarSaque();
        System.out.println(contaCorr.getDinheiro());
        contaCorr.tirarExtrato();
    }
}
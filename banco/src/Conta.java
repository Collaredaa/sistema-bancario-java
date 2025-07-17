public class Conta {
    private static int contador = 1;
    private int numeroConta;
    private String titular;
    private double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.numeroConta = contador++;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta + ", Titular: " + titular + ", Saldo: R$ " + saldo;
    }
}


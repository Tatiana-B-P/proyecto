package Modelo;

public class CuentaAhorros extends Cuenta {
    private double interes;

    // Constructor, getters y setters
    public CuentaAhorros(double balance, double interes) {
        super(balance);
        this.interes = interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public double consultarBalance() {
        return balance;
    }

    @Override
    public void depositar(double cantidad) throws ArithmeticException {
        if (cantidad < 0) {
            throw new ArithmeticException("No se puede depositar una cantidad negativa.");
        }
        balance += cantidad;
        System.out.println("Su saldo actual es: " + balance);
    }

    @Override
    public void retirar(double cantidad) throws ArithmeticException {
        if (cantidad < 0 || cantidad > balance) {
            throw new ArithmeticException("Cantidad inválida o saldo insuficiente.");
        }
        balance -= cantidad;
        System.out.println("Su saldo actual es: " + balance);
    }
}

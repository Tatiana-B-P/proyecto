package Modelo;

public abstract class Cuenta {
    protected double balance;

    public Cuenta(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double consultarBalance();
    public abstract void depositar(double cantidad) throws ArithmeticException;
    public abstract void retirar(double cantidad) throws ArithmeticException; 
}

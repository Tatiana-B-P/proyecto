package Modelo;

import java.util.ArrayList;

public class CuentaCredito extends Cuenta {
    private ArrayList<TarjetaCredito> tarjetas;

    // Constructor, getters y setters
    public CuentaCredito(double balance, ArrayList<TarjetaCredito> tarjetas) {
        super(balance);
        this.tarjetas = tarjetas;
    }

    public ArrayList<TarjetaCredito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<TarjetaCredito> tarjetas) {
        this.tarjetas = tarjetas;
    }

    @Override
    public double consultarBalance() {
        double totalDeuda = 0;
        for (TarjetaCredito tarjeta : tarjetas) {
            totalDeuda += tarjeta.getDeuda();
        }
        return totalDeuda;
    }

    @Override
    public void depositar(double cantidad) throws ArithmeticException {
        throw new UnsupportedOperationException("No se puede depositar en una cuenta de crédito.");
    }

    @Override
    public void retirar(double cantidad) throws ArithmeticException {
        throw new UnsupportedOperationException("No se puede retirar de una cuenta de crédito.");
    }
}

package Modelo;

public class TarjetaCredito {
    private int numero;
    private Cliente cliente;
    private double deuda;

    // Constructor, getters y setters
    public TarjetaCredito(int numero, Cliente cliente, double deuda) {
        this.numero = numero;
        this.cliente = cliente;
        this.deuda = deuda;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
}

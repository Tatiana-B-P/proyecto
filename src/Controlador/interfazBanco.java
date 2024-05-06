package Controlador;

import java.util.ArrayList;

import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.TarjetaCredito;

public interface interfazBanco {
    Cliente crearCliente(String nombre, String direccion, String documentoIdentidad);
    Cuenta crearCuentaAhorros(double balance, double interes);
    Cuenta crearCuentaCredito(double balance);
    void depositar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException;
    void retirar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException;
    void consultarTarjetas(Cliente cliente) throws NullPointerException;
    TarjetaCredito crearTarjeta(int numero, Cliente cliente);
    ArrayList<Cliente> getClientes();
    ArrayList<TarjetaCredito> getTarjetas();
}

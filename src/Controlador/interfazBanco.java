package Controlador;

import java.util.ArrayList;

import Modelo.Cliente;

public interface interfazBanco {
    Cliente crearCliente(String nombre, String direccion, String documentoIdentidad);
    void depositar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException;
    void retirar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException;
    void consultarTarjetas(Cliente cliente) throws NullPointerException;
    ArrayList<Cliente> getClientes();
}

package Controlador;

import java.util.ArrayList;

import Modelo.*;

public class ControladorBanco implements interfazBanco {
    private ArrayList<Cliente> clientes;

    public ControladorBanco() {
        clientes = new ArrayList<>();
    }

    @Override
    public Cliente crearCliente(String nombre, String direccion, String documentoIdentidad) {
        Cliente cliente = new Cliente(nombre, direccion, documentoIdentidad);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void depositar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException {
        if (cliente == null) {
            throw new NullPointerException("El cliente no existe.");
        }
        cliente.getCuenta().depositar(cantidad);
    }

    @Override
    public void retirar(Cliente cliente, double cantidad) throws ArithmeticException, NullPointerException {
        if (cliente == null) {
            throw new NullPointerException("El cliente no existe.");
        }
        cliente.getCuenta().retirar(cantidad);
    }

    @Override
    public void consultarTarjetas(Cliente cliente) throws NullPointerException {
        if (cliente == null) {
            throw new NullPointerException("El cliente no existe.");
        }
        if (cliente.getCuenta() instanceof CuentaCredito) {
            CuentaCredito cuentaCredito = (CuentaCredito) cliente.getCuenta();
            for (TarjetaCredito tarjeta : cuentaCredito.getTarjetas()) {
                System.out.println("Número de tarjeta: " + tarjeta.getNumero());
                System.out.println("Deuda: " + tarjeta.getDeuda());
            }
        } else {
            System.out.println("El cliente no tiene una cuenta de crédito.");
        }
    }
    @Override
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}


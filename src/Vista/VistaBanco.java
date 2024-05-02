package Vista;

// VistaBanco.java
import java.util.Scanner;

import Controlador.interfazBanco;
import Modelo.Cliente;

public class VistaBanco {
    private interfazBanco controlador;
    private Scanner scanner;

    public VistaBanco(interfazBanco controlador) {
        this.controlador = controlador;
        scanner = new Scanner(System.in);
    }

    public void crearCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el documento de identidad del cliente:");
        String documentoIdentidad = scanner.nextLine();

        controlador.crearCliente(nombre, direccion, documentoIdentidad);
        System.out.println("Cliente creado correctamente.");
    }

    public void depositar() {
        System.out.println("Ingrese el documento de identidad del cliente:");
        String documentoIdentidad = scanner.nextLine();
        Cliente cliente = buscarCliente(documentoIdentidad);
        if (cliente != null) {
            System.out.println("Ingrese la cantidad a depositar:");
            double cantidad = scanner.nextDouble();
            try {
                controlador.depositar(cliente, cantidad);
                System.out.println("Depósito realizado correctamente.");
            } catch (ArithmeticException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void retirar() {
        System.out.println("Ingrese el documento de identidad del cliente:");
        String documentoIdentidad = scanner.nextLine();
        Cliente cliente = buscarCliente(documentoIdentidad);
        if (cliente != null) {
            System.out.println("Ingrese la cantidad a retirar:");
            double cantidad = scanner.nextDouble();
            try {
                controlador.retirar(cliente, cantidad);
                System.out.println("Retiro realizado correctamente.");
            } catch (ArithmeticException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void consultarTarjetas() {
        System.out.println("Ingrese el documento de identidad del cliente:");
        String documentoIdentidad = scanner.nextLine();
        Cliente cliente = buscarCliente(documentoIdentidad);
        if (cliente != null) {
            try {
                controlador.consultarTarjetas(cliente);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private Cliente buscarCliente(String documentoIdentidad) {
        for (Cliente cliente : controlador.getClientes()) {
            if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }
}

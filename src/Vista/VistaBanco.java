package Vista;

import java.util.InputMismatchException;
// VistaBanco.java
import java.util.Scanner;

import Controlador.interfazBanco;
import Modelo.Cliente;
import Modelo.Cuenta;

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
        Cliente cliente = controlador.crearCliente(nombre, direccion, documentoIdentidad);
          
        System.out.println("Tipo de cuenta que desea crear: ");
        System.out.println("1. Cuenta de ahorros.");
        System.out.println("2. Cuenta de credito.");
        int opcion = scanner.nextInt();
        
        System.out.println("Ingrese el saldo inicial de la cuenta del cliente:");
        double saldo = scanner.nextDouble();
        
        if (opcion == 1) {
        	System.out.println("Ingrese el interes de la cuenta del cliente:");
            double interes = scanner.nextDouble();
            Cuenta cuenta = controlador.crearCuentaAhorros(saldo, interes);
            cliente.setCuenta(cuenta);
        }
        else {
        	System.out.println("Digite los datos de la tarjeta perteneciente a la cuenta credito.");
        	System.out.println("Ingrese el numero de la tarjeta credito del cliente:");
            int numero = scanner.nextInt();
            controlador.crearTarjeta(numero, cliente);
            Cuenta cuenta = controlador.crearCuentaCredito(saldo);
            cliente.setCuenta(cuenta);
            
        }
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
            } catch (ArithmeticException | NullPointerException e ) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e) {
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

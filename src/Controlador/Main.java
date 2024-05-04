package Controlador;

import java.util.Scanner;

import Vista.VistaBanco;

public class Main {
    public static void main(String[] args) {
        // Crear el controlador del banco
        interfazBanco controlador = new ControladorBanco();

        // Crear la vista del banco
        VistaBanco vista = new VistaBanco(controlador);

        // Ejecutar el menú principal
        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Consultar tarjetas de crédito");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    vista.crearCliente();
                    break;
                case 2:
                    vista.depositar();
                    break;
                case 3:
                    vista.retirar();
                    break;
                case 4:
                    vista.consultarTarjetas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
            //scanner.close();
        }
    }
}


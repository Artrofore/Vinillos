package Vista;

import Controlador.GestorVinilos;
import Modelo.Vinilo;

import java.util.Scanner;

public class Consola {
    private GestorVinilos gestor;
    private Scanner scanner;

    public Consola() {
        gestor = new GestorVinilos();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Mantenedor de Vinilos ---");
            System.out.println("1. Agregar Vinilo");
            System.out.println("2. Buscar Vinilo");
            System.out.println("3. Ver cantidad de vinilos");
            System.out.println("4. Ver espacios disponibles");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarVinilo();
                case 2 -> buscarVinilo();
                case 3 -> System.out.println("Total vinilos: " + gestor.contarVinilos());
                case 4 -> System.out.println("Espacios disponibles: " + gestor.espaciosDisponibles());
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void agregarVinilo() {
        System.out.print("Nombre del artista: ");
        String artista = scanner.nextLine();
        System.out.print("Nombre del disco: ");
        String disco = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        Vinilo vinilo = new Vinilo(artista, disco, anio);
        if (gestor.agregarVinilo(vinilo)) {
            System.out.println("Vinilo agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el vinilo (colección llena o duplicado).");
        }
    }

    private void buscarVinilo() {
        System.out.print("Nombre del disco a buscar: ");
        String disco = scanner.nextLine();
        Vinilo encontrado = gestor.buscarVinilo(disco);
        if (encontrado != null) {
            System.out.println("Vinilo encontrado: " + encontrado);
        } else {
            System.out.println("Vinilo no encontrado.");
        }
    }
}

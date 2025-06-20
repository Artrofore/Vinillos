package Controlador;

import Modelo.Vinilo;
import java.io.*;
import java.util.*;

public class GestorVinilos {
    private final String archivo = "Coleccion.txt";
    private final int MAX_VINILOS = 100;
    private ArrayList<Vinilo> coleccion;

    public GestorVinilos() {
        coleccion = new ArrayList<>();
        cargarColeccion();
    }

    private void cargarColeccion() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                coleccion.add(Vinilo.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void guardarColeccion() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Vinilo v : coleccion) {
                bw.write(v.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public boolean agregarVinilo(Vinilo v) {
        if (coleccion.size() >= MAX_VINILOS) return false;
        if (buscarVinilo(v.getDisco()) != null) return false;

        coleccion.add(v);
        guardarColeccion();
        return true;
    }

    public Vinilo buscarVinilo(String nombreDisco) {
        for (Vinilo v : coleccion) {
            if (v.getDisco().equalsIgnoreCase(nombreDisco)) {
                return v;
            }
        }
        return null;
    }

    public int contarVinilos() {
        return coleccion.size();
    }

    public int espaciosDisponibles() {
        return MAX_VINILOS - coleccion.size();
    }

    public List<Vinilo> obtenerTodos() {
        return new ArrayList<>(coleccion);
    }
}

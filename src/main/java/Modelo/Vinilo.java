package Modelo;

public class Vinilo {
    private String artista;
    private String disco;
    private int anio;

    public Vinilo(String artista, String disco, int anio) {
        this.artista = artista;
        this.disco = disco;
        this.anio = anio;
    }

    public String getArtista() {
        return artista;
    }

    public String getDisco() {
        return disco;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return artista + ";" + disco + ";" + anio;
    }

    public static Vinilo fromString(String linea) {
        String[] partes = linea.split(";");
        return new Vinilo(partes[0], partes[1], Integer.parseInt(partes[2]));
    }
}

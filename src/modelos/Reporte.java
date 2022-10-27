package modelos;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String nombreArtista;
    private String nombreAlbum;
    private String nombreCancion;
    private String nombreGenero;
    public static List<Reporte> reportes = new ArrayList<>();
    public Reporte() {
    }

    public Reporte(String nombreArtista, String nombreAlbum, String nombreCancion, String nombreGenero) {
        this.nombreArtista = nombreArtista;
        this.nombreAlbum = nombreAlbum;
        this.nombreCancion = nombreCancion;
        this.nombreGenero = nombreGenero;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}

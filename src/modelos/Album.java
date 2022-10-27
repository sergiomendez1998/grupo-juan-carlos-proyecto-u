package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album {
    private int id;
    private String nombre;
    private int anio;
    private int  artistaId;
    private Date creadoEl;
    private Date actualizadoEl;

    public static List<Album> albums= new ArrayList<>();

    public Album() {
    }

    public Album(int id, String nombre, int anio, int artistaId, Date creadoEl, Date actualizadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.artistaId = artistaId;
        this.creadoEl = creadoEl;
        this.actualizadoEl = actualizadoEl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

    public Date getActualizadoEl() {
        return actualizadoEl;
    }

    public void setActualizadoEl(Date actualizadoEl) {
        this.actualizadoEl = actualizadoEl;
    }
}

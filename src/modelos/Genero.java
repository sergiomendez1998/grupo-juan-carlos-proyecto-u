package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Genero {
    private int id;
    private String nombre;
    private Date creadoEl;
    private Date actualizadoEl;

    public Genero(int id, String nombre, Date creadoEl, Date actualizadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.creadoEl = creadoEl;
        this.actualizadoEl = actualizadoEl;
    }

    public static List<Genero> generos= new ArrayList<>();
    public Genero() {
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

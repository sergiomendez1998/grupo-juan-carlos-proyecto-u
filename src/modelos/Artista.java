package modelos;

import java.util.*;

public class Artista {
    private  int id;
    private  String nombre;
    private  String genero;
    private int edad;
    private  String nacionalidad;
    private Date creadoEl;
    private Date actualizadoEl;
    public static List<Artista> artistas= new ArrayList<>();
    private List<Album> albums = new ArrayList<>();
    public Artista() {
    }

    public Artista(int id, String nombre, String genero, int edad, String nacionalidad, Date creadoEl, Date actualizadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

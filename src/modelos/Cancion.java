package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cancion {

    private int id;
    private String nombre;
    private int generoId;
    private int albumId;
    private int artistaId;
    private Date creadoEl;
    private Date actualizadoEl;
    public static List<Cancion> canciones = new ArrayList<>();

    public Cancion() {
    }


    public Cancion(int id, String nombre, int generoId, int artistaId, int albumId, Date creadoEl, Date actualizadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.generoId = generoId;
        this.artistaId = artistaId;
        this.albumId = albumId;
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

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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

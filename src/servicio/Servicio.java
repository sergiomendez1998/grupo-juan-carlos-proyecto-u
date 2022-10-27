package servicio;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Album;
import modelos.Artista;
import modelos.Cancion;
import modelos.Genero;

public class Servicio {
    
    public static String id;
    public static String nombre;

    public static Album buscarAlbumPorId(int id){
        for (Album album : Album.albums) {
            if(album.getId()==id){
                return album;
            }
        }
        return null;
    }

    public static Genero GeneroBuscarGeneroPorId(int id){
        for (Genero genero : Genero.generos) {
            if(genero.getId()==id){
                return genero;
            }
        }
        return null;
    }

    public  static Artista buscarArtistaPorId(int id){
        for (Artista artista : Artista.artistas) {
            if(artista.getId()==id){
                return artista;
            }
        }
        return null;
    }

    public static Cancion buscarCancionPorId(int id){
        for (Cancion cancion : Cancion.canciones) {
            if(cancion.getId()==id){
                return cancion;
            }
        }
        return null;
    }
    
      public static void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount() - 1;
            for (int i = a; i >= 0; i++) {
                tbl.removeRow(tabla.getRowCount() - 1);
            }
        } catch (Exception e) {
        }
    }
      
    

}

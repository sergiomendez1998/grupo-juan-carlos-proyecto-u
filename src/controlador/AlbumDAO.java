package controlador;

import conecciondba.ConeccionDBA;
import convertidor.Convertidor;
import modelos.Album;

import java.sql.*;

public class AlbumDAO {

    private final String SQL_INSERT = "INSERT INTO Album (nombre, anio, artista_id, creado_el) VALUES (?,?,?,?)";
    private final String SQL_UPDATE_ARTISTA = "UPDATE Album SET nombre=?, anio=?, artista_id=?, actualizado_el=? WHERE id=?";
    private final String SQL_UPDATE_ALBUM = "UPDATE Album SET nombre=?, anio=?, actualizado_el=? WHERE id=?";
    private final String SQL_DELETE = "DELETE FROM Album WHERE id=?";
    private final String SQL_SELECT = "SELECT * FROM Album";

    public void obtenerAlbum() {
        try ( Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int anio = resultSet.getInt("anio");
                int artistaId = resultSet.getInt("artista_id");
                Date creadoEl = resultSet.getDate("creado_el");
                Date actualizadoEl = resultSet.getDate("actualizado_el");
                Album album = new Album(id, nombre, anio, artistaId, creadoEl, actualizadoEl);
                Album.albums.add(album);
            }
            preparedStatement.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void guardarAlbum(Album album) {
        java.sql.Date creadoEl = Convertidor.convertidortoSql(album.getCreadoEl());

        try ( Connection connection = ConeccionDBA.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            if (album.getArtistaId() != 0) {
                preparedStatement.setString(1, album.getNombre());
                preparedStatement.setInt(2, album.getAnio());
                preparedStatement.setInt(3, album.getArtistaId());
                preparedStatement.setDate(4, creadoEl);
            } else {
                preparedStatement.setString(1, album.getNombre());
                preparedStatement.setInt(2, album.getAnio());
                preparedStatement.setNull(3, Types.NULL);
                preparedStatement.setDate(4, creadoEl);
            }

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void actualizarAlbumArtista(Album album) {
        java.sql.Date actualizadoEl = Convertidor.convertidortoSql(album.getActualizadoEl());
        try ( Connection connection = ConeccionDBA.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ARTISTA);
            preparedStatement.setString(1, album.getNombre());
            preparedStatement.setInt(2, album.getAnio());
            preparedStatement.setInt(3, album.getArtistaId());
            preparedStatement.setDate(4, actualizadoEl);
            preparedStatement.setInt(5, album.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();

        }
    }

    public void actualizarAlbumSiArtista(Album album) {
        java.sql.Date actualizadoEl = Convertidor.convertidortoSql(album.getActualizadoEl());
        try ( Connection connection = ConeccionDBA.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ALBUM);
            preparedStatement.setString(1, album.getNombre());
            preparedStatement.setInt(2, album.getAnio());
            preparedStatement.setDate(3, actualizadoEl);
            preparedStatement.setInt(4, album.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();

        }
    }

    public void eleminarAlbum(int id) {
        try ( Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}

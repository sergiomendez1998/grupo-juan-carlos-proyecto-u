package controlador;

import conecciondba.ConeccionDBA;
import convertidor.Convertidor;
import modelos.Cancion;

import java.sql.*;

public class CancionDAO {

    private final String SQL_INSERT = "INSERT INTO Cancion (nombre, genero_id, artista_id, album_id,creado_el) VALUES (?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE Cancion SET nombre=?, actualizado_el=? WHERE id=?";
    private final String SQL_DELETE = "DELETE FROM Cancion WHERE id=?";
    private final String SQL_SELECT = "SELECT * FROM Cancion";

    public void obtenerCancion() {
        try ( Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int generoId = resultSet.getInt("genero_id");
                int artistaId = resultSet.getInt("artista_id");
                int albumId = resultSet.getInt("album_id");
                Date creadoEl = resultSet.getDate("creado_el");
                Date actualizadoEl = resultSet.getDate("actualizado_el");
                Cancion cancion = new Cancion(id, nombre, generoId, artistaId, albumId, creadoEl, actualizadoEl);
                Cancion.canciones.add(cancion);
            }
            preparedStatement.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void guardarCancion(Cancion cancion) {
        java.sql.Date creadoEl = Convertidor.convertidortoSql(cancion.getCreadoEl());
        try ( Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, cancion.getNombre());
            preparedStatement.setInt(2, cancion.getGeneroId());
            preparedStatement.setInt(3, cancion.getArtistaId());
            preparedStatement.setInt(4, cancion.getAlbumId());
            preparedStatement.setDate(5, creadoEl);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void actualizarCancion(Cancion cancion) {
        java.sql.Date actualizadoEl = Convertidor.convertidortoSql(cancion.getActualizadoEl());
        try ( Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, cancion.getNombre());
            preparedStatement.setDate(2, actualizadoEl);
            preparedStatement.setInt(3, cancion.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void eliminarCancion(int id) {
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

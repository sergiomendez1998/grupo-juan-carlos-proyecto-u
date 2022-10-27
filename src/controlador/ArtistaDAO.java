package controlador;

import conecciondba.ConeccionDBA;
import convertidor.Convertidor;
import modelos.Artista;
import modelos.Reporte;

import java.sql.*;

public class ArtistaDAO {

    private final String SQL_INSERT = "INSERT INTO Artista (nombre,genero,edad,nacionalidad,creado_el) VALUES (?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE Artista SET nombre=?, genero=?, edad=?, nacionalidad=?, actualizado_el=? WHERE id=?";
    private final String SQL_DELETE = "DELETE FROM Artista WHERE id=?";
    private final String SQL_SELECT = "SELECT * FROM Artista";
    private final String SQL_SELECT_CANCIONES_ARTISTA = "select a.nombre as nombreArtista, A2.nombre as nombreAlbum, C.nombre as nombreCancion, G.nombre as genero from Artista a\n"
            + "inner join Album A2 on a.id = A2.artista_id\n"
            + "inner join Cancion C on A2.id = C.album_id\n"
            + "inner join Genero G on C.genero_id = G.id\n"
            + "where a.id = ?";

    public void obtenerArtista() {
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String genero = resultSet.getString("genero");
                int edad = resultSet.getInt("edad");
                String nacionalidad = resultSet.getString("nacionalidad");
                Date creadoEl = resultSet.getDate("creado_el");
                Date actualizadoEl = resultSet.getDate("actualizado_el");
                Artista artista = new Artista(id, nombre, genero, edad, nacionalidad, creadoEl, actualizadoEl);
                Artista.artistas.add(artista);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarArtista(Artista a) {
        java.sql.Date creadoEl = Convertidor.convertidortoSql(a.getCreadoEl());
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, a.getNombre());
            preparedStatement.setString(2, a.getGenero());
            preparedStatement.setInt(3, a.getEdad());
            preparedStatement.setString(4, a.getNacionalidad());
            preparedStatement.setDate(5, creadoEl);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarArtista(Artista artista) {
        java.sql.Date actualizadoEl = Convertidor.convertidortoSql(artista.getActualizadoEl());
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, artista.getNombre());
            preparedStatement.setString(2, artista.getGenero());
            preparedStatement.setInt(3, artista.getEdad());
            preparedStatement.setString(4, artista.getNacionalidad());
            preparedStatement.setDate(5, actualizadoEl);
            preparedStatement.setInt(6, artista.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarArtista(int id) {
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerCancionesArtista(int id) {
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CANCIONES_ARTISTA);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nombreArtista = resultSet.getString("nombreArtista");
                String nombreAlbum = resultSet.getString("nombreAlbum");
                String nombreCancion = resultSet.getString("nombreCancion");
                String genero = resultSet.getString("genero");
                Reporte reporte = new Reporte(nombreArtista, nombreAlbum, nombreCancion, genero);
                Reporte.reportes.add(reporte);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

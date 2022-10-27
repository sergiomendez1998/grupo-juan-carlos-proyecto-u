package controlador;

import conecciondba.ConeccionDBA;
import convertidor.Convertidor;
import modelos.Genero;

import java.sql.*;

public class GeneroDAO {

    private final String OBTENER_DATOS_GENEROS = "SELECT * FROM Genero";
    private final String INSERTAR_DATOS_GENEROS = "INSERT INTO Genero (id,nombre,creado_el) VALUES (?,?,?)";
    private final String ACTUALIZAR_DATOS_GENEROS = "UPDATE Genero SET nombre = ?, actualizado_el= ? WHERE id = ?";
    private final String ELIMINAR_DATOS_GENEROS = "DELETE FROM Genero WHERE id = ?";

    public void listarGeneros() {
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(OBTENER_DATOS_GENEROS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Date creadoEl = resultSet.getDate("creado_el");
                Date actualizadoEl = resultSet.getDate("actualizado_el");
                Genero genero = new Genero(id, nombre, creadoEl, actualizadoEl);
                Genero.generos.add(genero);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void guardarGenero(Genero genero) {
        java.sql.Date creadoEl = Convertidor.convertidortoSql(genero.getCreadoEl());
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_DATOS_GENEROS);
            preparedStatement.setInt(1, genero.getId());
            preparedStatement.setString(2, genero.getNombre());
            preparedStatement.setDate(3, creadoEl);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarGenero(Genero genero) {
        java.sql.Date actualizadoEl = Convertidor.convertidortoSql(genero.getActualizadoEl());
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ACTUALIZAR_DATOS_GENEROS);
            preparedStatement.setString(1, genero.getNombre());
            preparedStatement.setDate(2, actualizadoEl);
            preparedStatement.setInt(3, genero.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGenero(int id) {
        try (Connection connection = ConeccionDBA.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_DATOS_GENEROS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

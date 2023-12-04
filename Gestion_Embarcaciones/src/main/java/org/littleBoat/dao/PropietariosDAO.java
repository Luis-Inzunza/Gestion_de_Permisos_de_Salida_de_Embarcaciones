
/**
 * La clase PropietariosDAO proporciona métodos de acceso a datos para interactuar con la tabla PROPIETARIOS en la base de datos.
 * Incluye métodos para guardar, buscar por ID de propietario, buscar por nombre, y recuperar todos los propietarios.
 *
 * @version 1.0
 */package org.littleboat.dao;

import org.littleboat.connection.ConnectionManager;

import org.littleboat.dto.PropietariosDTO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropietariosDAO extends PaginDao{
    private ConnectionManager connectionManager;
    private static final Logger LOGGER = Logger.getLogger(PropietariosDAO.class.getName());
    public PropietariosDAO(ConnectionManager connection) {

        this.connectionManager = connection;
        setPages(calculatePages());
        setTotalRecords(countRecords());
    }


    /**
     * Guarda el objeto PropietariosDTO proporcionado en la tabla PROPIETARIOS de la
     * base de datos.
     *
     * @param propietario El objeto PropietariosDTO que se va a guardar.
     * @return 1 si se pudo guardar el registro, -1 si hubo algún problema con la base de datos.
     */
    public int save(PropietariosDTO propietario){
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO PROPIETARIOS (NOMPROP, APSPROP, TELEFONO, CORREO, ESTADOPROP) VALUES (?, ?, ?, ?, ?);";
            statement = connection.prepareStatement(query);
            statement.setString(1, propietario.getNomProp());
            statement.setString(2, propietario.getApsProp());
            statement.setString(3, propietario.getTelefono());
            statement.setString(4, propietario.getCorreo());
            statement.setBoolean(5, propietario.getEstadoProp());

            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            return -1;
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
    }

    /**
     * Guarda el objeto PropietariosDTO proporcionado en la tabla PROPIETARIOS de la
     * base de datos.
     *
     * @param matricula El objeto PropietariosDTO que se va a guardar.
     * @return la entidad unica en la base de datos o nulo si no la encontro.
     */
    public PropietariosDTO findByIdProp(int matricula){
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "SELECT * FROM PROPIETARIOS WHERE IdProp = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PropietariosDTO propietario = new PropietariosDTO(
                        resultSet.getInt("IdProp"),  // Asegúrate de que "IdProp" sea el nombre correcto
                        resultSet.getString("NomProp"),
                        resultSet.getString("ApsProp"),
                        resultSet.getString("Telefono"),
                        resultSet.getString("Correo"),
                        resultSet.getBoolean("EstadoProp")
                );

                return propietario;
            }
        } catch ( SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return null;
    }

    /**
     * Busca un objeto PropietariosDTO en la tabla PROPIETARIOS basado en el nombre
     * proporcionado.
     *
     * @param name El nombre del propietario para el cual se buscará el propietario.
     * @return Un objeto PropietariosDTO correspondiente al nombre proporcionado, o
     *         null si no se encuentra.
     */
    public PropietariosDTO findByName (String name) {
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM PROPIETARIOS WHERE PROPIETARIOS.NOMPROP = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.toString());

            return new PropietariosDTO(
                    resultSet.getInt("IDPROP"),
                    resultSet.getString("NOMPROP"),
                    resultSet.getString("APSPROP"),
                    resultSet.getString("TELEFONO"),
                    resultSet.getString("CORREO"),
                    resultSet.getBoolean("ESTADOPROP")
            );
        } catch ( SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return null;
    }

    /**
     * Recupera una lista de todos los objetos PropietariosDTO de la tabla
     * PROPIETARIOS.
     *
     * @return Una lista de objetos PropietariosDTO.
     */
    public List<PropietariosDTO> findAll(){
        ArrayList<PropietariosDTO> propietarios = new ArrayList<>();
        Connection connection = this.connectionManager.getConnection();
        Statement statement = null;
        try  {
            statement = connection.createStatement();
            String query = "SELECT * FROM PROPIETARIOS";
            ResultSet resultSet = statement.executeQuery(query);

            while ( resultSet.next() ) {
                PropietariosDTO propietario = new PropietariosDTO(
                        resultSet.getInt("IDPROP"),
                        resultSet.getString("NOMPROP"),
                        resultSet.getString("APSPROP"),
                        resultSet.getString("TELEFONO"),
                        resultSet.getString("CORREO"),
                        resultSet.getBoolean("ESTADOPROP")
                );
                propietarios.add(propietario);
            }

        } catch ( SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return propietarios;
    }
    /**
     * Actuliza los valores de una entidad segun su clave primaria,
     * la cual se especifica en la misma instancia de propietario
     * @param propietario El objeto PropietariosDTO que se va a guardar.
     * @return 1 si la actualización de los datos fue exitosa,
     * -1 si hubo un problema en la ejecución de la sentencia.
     */
    public int update(PropietariosDTO propietario) {
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "UPDATE PROPIETARIOS SET NOMPROP=?, APSPROP=?, TELEFONO=?, CORREO=?, ESTADOPROP=? WHERE IdProp=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, propietario.getNomProp());
            statement.setString(2, propietario.getApsProp());
            statement.setString(3, propietario.getTelefono());
            statement.setString(4, propietario.getCorreo());
            statement.setBoolean(5, propietario.getEstadoProp());
            statement.setInt(6, propietario.getIdProp());

            int result = statement.executeUpdate();
            statement.close();
            return result;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            return -1;
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
    }
    /**
     * Borra una única entidad en la base de datos según su llave primaria
     * @param idProp El objeto PropietariosDTO que se va a guardar.
     * @return 1 si la actualización de los datos fue exitosa,
     * -1 si hubo un problema en la ejecución de la sentencia.
     */
    public int deleteByIdProp(int idProp) {
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "DELETE FROM PROPIETARIOS WHERE IdProp=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idProp);

            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            return -1;
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
    }

    /**
     * Clase implementada para poder paginar registros de la tabla PROPIETARIOS.
     * @param page el número de pagina para buscar los registros.
     * @return una lista de los registro de la tabla PROPIETARIOS según la pagina proporcionada.
     * */
    @Override
    public List<PropietariosDTO> findPage(int page) {
        List<PropietariosDTO> propietarios = new ArrayList<>();
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {

            String query = "SELECT * FROM PROPIETARIOS LIMIT ?  OFFSET  ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, this.getLimit());
            statement.setInt(2, calculateOffset(page));
            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() ) {
                PropietariosDTO propietario = new PropietariosDTO(
                        resultSet.getInt("IDPROP"),
                        resultSet.getString("NOMPROP"),
                        resultSet.getString("APSPROP"),
                        resultSet.getString("TELEFONO"),
                        resultSet.getString("CORREO"),
                        resultSet.getBoolean("ESTADOPROP")
                );
                propietarios.add(propietario);
            }

        } catch ( SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return propietarios;
    }

    /**
     * Clase implementada para contar los registros de la tabla PROPIETARIOS.
     * @return el número de registros detro de una tabla.
     * */
    @Override
    protected int countRecords() {
        Connection connection = this.connectionManager.getConnection();
        Statement statement = null;
        try  {
            String query = "SELECT COUNT(*) FROM PROPIETARIOS";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getInt(1);
        } catch ( SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            return -1;
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }

    }
}

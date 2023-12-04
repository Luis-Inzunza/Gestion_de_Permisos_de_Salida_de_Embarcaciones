/**
 * La clase PermisoPescaComDAO proporciona métodos de acceso a datos para interactuar con la tabla PERMISO_PESCA_COM en la base de datos.
 * Incluye métodos para guardar, buscar por matrícula, eliminar por matrícula, actualizar la fecha de vigencia y recuperar por matrícula.
 *
 * @version 1.0
 */
package org.littleboat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.littleboat.connection.ConnectionInterface;
import org.littleboat.dto.PermisoPescaComDTO;

public class PermisoPescaComDAO {
    private final Logger LOGGER = Logger.getLogger(PermisoPescaComDAO.class.getName());
    private final ConnectionInterface connectionManager;

    public PermisoPescaComDAO(ConnectionInterface connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto PermisoPescaComDTO proporcionado en la tabla
     * PERMISO_PESCA_COM de la base de datos.
     *
     * @param permiso El objeto PermisoPescaComDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(PermisoPescaComDTO permiso) {

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO PERMISO_PESCA_COM (NOPERMISO, MATRICULA, FVIGENCIAPPC) VALUES (?, ?, ?) ";
            statement = connection.prepareStatement(query);
            statement.setString(1, permiso.getNoPermiso());
            statement.setInt(2, permiso.getMatricula());
            statement.setDate(3, java.sql.Date.valueOf(permiso.getFVigenciaPPC()));

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
     * Elimina un objeto PermisoPescaComDTO de la tabla PERMISO_PESCA_COM basado en
     * la matrícula proporcionada.
     *
     * @param matricula La matrícula para la cual se eliminarán los permisos de
     *                  pesca comercial.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByMatricula(int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM PERMISO_PESCA_COM WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            e.printStackTrace();
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
     * Elimina un objeto PermisoPescaComDTO de la tabla PERMISO_PESCA_COM basado en
     * su Número de permiso proporcionada.
     *
     * @param noPermiso La matrícula para la cual se eliminarán los permisos de
     *                  pesca comercial.
     * @return El número de filas afectadas en la base de datos y -1 si hubo algún
     *         error.
     */
    public int deleteByNoPermiso(String noPermiso) {
        String query = "DELETE FROM PERMISO_PESCA_COM WHERE NOPERMISO = ?";

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, noPermiso);
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
     * Actualiza la fecha de vigencia de la entidad correpondiente al parametro
     *
     * @param permiso El objeto PermisoPescaComDTO con la información actualizada.
     * @return 1 si se pudo concretar la actualización, -1 si hubo algun fallo en la
     *         base de datos.
     */
    public int updateFechaVigencia(PermisoPescaComDTO permiso) {
        String query = "UPDATE PERMISO_PESCA_COM SET FVIGENCIAPPC = ? WHERE MATRICULA = ? AND NOPERMISO = ?";

        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setDate(1, java.sql.Date.valueOf(permiso.getFVigenciaPPC()));
            statement.setInt(2, permiso.getMatricula());
            statement.setString(3, permiso.getNoPermiso());
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
     * Recupera una lista de objetos PermisoPescaComDTO de la tabla
     * PERMISO_PESCA_COM basados en la matrícula proporcionada.
     *
     * @param matricula La matrícula para la cual se buscarán los permisos de pesca
     *                  comercial.
     * @return Una lista de objetos PermisoPescaComDTO correspondientes a la
     *         matrícula proporcionada.
     */
    public List<PermisoPescaComDTO> findByMatricula(int matricula) {
        List<PermisoPescaComDTO> permisosList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT NOPERMISO, MATRICULA, FVIGENCIAPPC FROM PERMISO_PESCA_COM WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PermisoPescaComDTO permiso = new PermisoPescaComDTO();
                permiso.setMatricula(resultSet.getInt("MATRICULA"));
                permiso.setFVigenciaPPC(resultSet.getDate("FVIGENCIAPPC").toLocalDate());
                permiso.setNoPermiso(resultSet.getString("NOPERMISO"));
                permisosList.add(permiso);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        } finally {
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return permisosList;
    }

}

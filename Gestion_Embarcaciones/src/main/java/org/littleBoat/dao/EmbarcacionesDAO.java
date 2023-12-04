/**
 * La clase EmbarcacionesDAO proporciona métodos de acceso a datos para interactuar con la tabla EMBARCACIONES en la base de datos.
 * Incluye un método para guardar objetos EmbarcacionesDTO y otro para recuperar todas las embarcaciones registradas.
 *
 * @version 1.0
 */
package org.littleboat.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.littleboat.connection.ConnectionManager;
import org.littleboat.dto.EmbarcacionesDTO;

public class EmbarcacionesDAO {
    private final ConnectionManager connectionManager;
    private static final Logger LOGGER = Logger.getLogger(EmbarcacionesDAO.class.getName());

    public EmbarcacionesDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto EmbarcacionesDTO proporcionado en la tabla EMBARCACIONES de
     * la base de datos.
     *
     * @param embarcacion El objeto EmbarcacionesDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(EmbarcacionesDTO embarcacion) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO EMBARCACIONES (MATRICULA, F_SALIDA, F_REGRESO) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, embarcacion.getMatricula());
            statement.setDate(2, java.sql.Date.valueOf(embarcacion.getFSalida()));
            statement.setDate(3, java.sql.Date.valueOf(embarcacion.getFRegreso()));

            return statement.executeUpdate();
        } catch (SQLException e) {
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
     * Recupera una lista de objetos EmbarcacionesDTO de la tabla EMBARCACIONES.
     *
     * @return Una lista de objetos EmbarcacionesDTO que representan todas las
     *         embarcaciones registradas.
     */
    public List<EmbarcacionesDTO> findAll() {
        String query = "SELECT MATRICULA, F_SALIDA, F_REGRESO FROM EMBARCACIONES";
        List<EmbarcacionesDTO> embarcacionesList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try  {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmbarcacionesDTO embarcacion = new EmbarcacionesDTO();
                embarcacion.setMatricula(resultSet.getInt("MATRICULA"));
                embarcacion.setFSalida(resultSet.getDate("F_SALIDA").toLocalDate());
                embarcacion.setFRegreso(resultSet.getDate("F_REGRESO").toLocalDate());
                embarcacionesList.add(embarcacion);
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
        return embarcacionesList;
    }

    /**
     * Actializa la información de la entidad con respecto a su llave primaria
     *
     * @param embarcacion El objeto EmbarcacionesDTO con la información actualizada.
     * @return 1 si se pudo concretar la actualización, -1 si hubo algun fallo en la base de datos.
     */
    public int update (EmbarcacionesDTO embarcacion) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement  = null;
        try {
            String query = "UPDATE EMBARCACIONES SET FREGRESO=? WHERE MATRICULA = ? AND FSALIDA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, embarcacion.getMatricula());
            statement.setDate(2, Date.valueOf(embarcacion.getFSalida()));
            return statement.executeUpdate();
        } catch (SQLException e) {
            return -1;
        } finally {
            connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            }catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
    }

    /**
     * Elimina todas las entidades que comparten el campo MATRICULA en la base de datos
     *
     * @param matricula El objeto EmbarcacionesDTO con la información actualizada.
     * @return el numero de entidades eliminadas, -1 si hubo algun fallo en la base de datos.
     */
    public int deleteByMatricula (int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM EMBARCACIONES WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            return statement.executeUpdate();
        } catch (SQLException e) {
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
     * Elimina una entidad concreta con respecto a su llave primaria
     *
     * @param matricula campo que conforma su llave primaria dentro de la base de datos
     * @param fSalida segundo campo que conforma su llave primera dentro de la base de datos
     * @return 1 si se pudo eliminar correctamente, -1 si hubo algun fallo en la base de datos.
     */
    public int deleteByMatriculaAndFsalida (int matricula, LocalDate fSalida) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM EMBARCACIONES WHERE MATRICULA = ? AND FSALIDA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            statement.setDate(2, Date.valueOf(fSalida));
            return statement.executeUpdate();
        } catch (SQLException e) {
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

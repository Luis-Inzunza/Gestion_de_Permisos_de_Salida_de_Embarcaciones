/**
 * La clase TipoPescaDAO proporciona métodos de acceso a datos para interactuar con la tabla TipoPesca en la base de datos.
 * Incluye metodos para el acceso y/o modificación de las entidades de la base de datos de la tabla anterior mente dicha. 
 *
 * @version 1.0
**/
package org.littleboat.dao;

import org.littleboat.connection.ConnectionManager;
import org.littleboat.connection.H2Connection;
import org.littleboat.dto.TipoPescaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoPescaDAO {
    private final ConnectionManager connectionManager;
    private static final Logger LOGGER = Logger.getLogger(TipoPescaDAO.class.getName());

    public TipoPescaDAO(H2Connection instance) {
        this.connectionManager = instance;
    }
    /**
     * Guarda una nueva entidad dentro de la tabla TipoPesca
     *
     * @param tipoPesca El objeto TripulantesDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save (TipoPescaDTO tipoPesca) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "INSERT INTO TIPOPESCA (NOPERMISO, NOESPECIE, ESPECIE) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, tipoPesca.getNoPermiso());
            statement.setInt(2, tipoPesca.getNoEspecie());
            statement.setString(3, tipoPesca.getEspecie());
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
     * Borra todas las entidades de la tabla TipoPesca que esten relacionadas con una entidad de
     * la tabla PERMISO_PESCA_COM
     * @param noPermiso la clave foranea que identifica a todas las entidades.
     * @return el número de entidades eliminadas,
     * -1 si hubo un problema en la ejecución de la sentencia.
     */
    public  int deleteByNoPermiso(String noPermiso) {
        String query = "DELETE FROM TIPOPESCA WHERE NOPERMISO = ?";
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
     * Borra una única entidad de la tabla TipoPesca con respecto a su llave primaria
     * @param noPermiso primer campo necesario para formar su llave primaria.
     * @param noEspecie segundo campo necesario para formar su llave primaria
     * @return el número de entidades eliminadas,
     * -1 si hubo un problema en la ejecución de la sentencia.
     */
    public int deleteByNoPermisoAndNoEspecie(String noPermiso, int noEspecie) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM TIPOPESCA WHERE NOPERMISO = ? AND NOESPECIE = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, noPermiso);
            statement.setInt(2, noEspecie);
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
     * Busca todas las entidades dentro de la tabla de TIPOPESCA que compartan el NoPermiso devolviendolas
     * como una lista de instancias de la clase TipoPescaDTO
     *
     * @param noPermiso El número de permiso para filtrar las entidades dentro de la base de datos.
     * @return Un objeto PropietariosDTO correspondiente al nombre proporcionado, o
     *         null si no se encuentra.
     */

    public List<TipoPescaDTO> findByNoPermiso (String noPermiso) {
        ArrayList<TipoPescaDTO> tipoPesca = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try  {
            String query = "SELECT * FROM TIPOPESCA WHERE NOPERMISO = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, noPermiso);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tipoPesca.add(new TipoPescaDTO(
                        resultSet.getString("NOPERMISO"),
                        resultSet.getInt("NOESPECIE"),
                        resultSet.getString("ESPECIE")));
            }
            return tipoPesca;
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
        return null;
    }
    /**
     * Guarda una instancia de la clase TipoPescaDTO en la tabla TIPOPesca
     *
     * @param tipoPesca La instancia que se va a guardar en la base de datos como una nueva entidad.
     * @return 1 si se pudo guardar el registro, -1 si hubo algún problema con la base de datos.
     */

    public int update (TipoPescaDTO tipoPesca) {
        String query = "UPDATE TIPOPESCA SET ESPECIE = ?, NOPERMISO = ? WHERE NOESPECIE = ?";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, tipoPesca.getEspecie());
            statement.setString(2, tipoPesca.getNoPermiso());
            statement.setInt(3, tipoPesca.getNoEspecie());
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
}

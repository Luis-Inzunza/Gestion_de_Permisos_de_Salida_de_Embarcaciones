/**
 * La clase TripulantesDAO proporciona métodos de acceso a datos para interactuar con la tabla TRIPULANTES en la base de datos.
 * Incluye métodos para buscar por matrícula, eliminar por matrícula, guardar, actualizar, buscar por CURP y recuperar todos los tripulantes.
 *
 * @version 1.0
 */
package org.littleboat.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.littleboat.connection.ConnectionManager;
import org.littleboat.dto.TripulantesDTO;

public class TripulantesDAO {
    private final ConnectionManager connectionManager;
    private static final Logger LOGGER = Logger.getLogger(TripulantesDAO.class.getName());

    public TripulantesDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Busca tripulantes por matrícula en la tabla TRIPULANTES.
     *
     * @param matricula La matrícula para la cual se buscarán tripulantes.
     * @return Una lista de objetos TripulantesDTO correspondientes a la matrícula
     *         proporcionada.
     */
    public List<TripulantesDTO> findByMatricula(int matricula) {
        List<TripulantesDTO> tripulantesList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT CURP, NOMTRIPULANTE, APSTRIPULANTE, MATRICULA FROM TRIPULANTES WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TripulantesDTO tripulante = new TripulantesDTO();
                tripulante.setCurp(resultSet.getString("CURP"));
                tripulante.setNomTripulante(resultSet.getString("NOMTRIPULANTE"));
                tripulante.setApsTripulante(resultSet.getString("APSTRIPULANTE"));
                tripulante.setMatricula(resultSet.getInt("MATRICULA"));
                tripulantesList.add(tripulante);
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
        return tripulantesList;
    }

    /**
     * Elimina tripulantes por matrícula de la tabla TRIPULANTES.
     *
     * @param matricula La matrícula para la cual se eliminarán tripulantes.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByMatricula(int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM TRIPULANTES WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
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
     * Guarda un objeto TripulantesDTO en la tabla TRIPULANTES.
     *
     * @param tripulante El objeto TripulantesDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(TripulantesDTO tripulante) {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO TRIPULANTES (CURP, NOMTRIPULANTE, APSTRIPULANTE, MATRICULA) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, tripulante.getCurp());
            statement.setString(2, tripulante.getNomTripulante());
            statement.setString(3, tripulante.getApsTripulante());
            statement.setInt(4, tripulante.getMatricula());

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
     * Actualiza una entidad de la tabla Tripulantes con respecto a la llave
     * foranea, encontrada
     * en la instancia pasada como parametro.
     * 
     * @param tripulante instancia que representa a una entidad en la tabla
     *                   Tripulantes con información actualizada.
     * @return 1 si la actualización fue exitosa, -1 si ocurrio algo mal en el
     *         sistema de base de datos.
     */
    public int update(TripulantesDTO tripulante) {
        // Implementar
        return 0;
    }

    /**
     * Busca una única entidad en la tabla de Tripulantes con respecto a su llave
     * foranea.
     *
     * @param curp El objeto TripulantesDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public TripulantesDTO findByCurp(String curp) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT CURP, NOMTRIPULANTE, APSTRIPULANTE, MATRICULA FROM TRIPULANTES WHERE CURP = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, curp);
            resultSet = statement.executeQuery();
            TripulantesDTO tripulante = new TripulantesDTO();
            if (resultSet.next()) {

                tripulante.setCurp(resultSet.getString("CURP"));
                tripulante.setNomTripulante(resultSet.getString("NOMTRIPULANTE"));
                tripulante.setApsTripulante(resultSet.getString("APSTRIPULANTE"));
                tripulante.setMatricula(resultSet.getInt("MATRICULA"));
                return tripulante;
            }
            return tripulante;
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
     * Recupera una lista de todos los tripulantes en la tabla TRIPULANTES.
     *
     * @return Una lista de objetos TripulantesDTO.
     */
    public List<TripulantesDTO> findAll() {
        String query = "SELECT CURP, NOMTRIPULANTE, APSTRIPULANTE, MATRICULA FROM TRIPULANTES";
        List<TripulantesDTO> tripulantesList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                TripulantesDTO tripulante = new TripulantesDTO();
                tripulante.setCurp(resultSet.getString("CURP"));
                tripulante.setNomTripulante(resultSet.getString("NOMTRIPULANTE"));
                tripulante.setApsTripulante(resultSet.getString("APSTRIPULANTE"));
                tripulante.setMatricula(resultSet.getInt("MATRICULA"));
                tripulantesList.add(tripulante);
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
        return tripulantesList;
    }

}

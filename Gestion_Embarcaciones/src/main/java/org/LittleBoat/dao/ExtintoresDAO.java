/**
 * La clase ExtintoresDAO proporciona métodos de acceso a datos para interactuar con la tabla EXTINTORES en la base de datos.
 * Incluye métodos para guardar, buscar por matrícula, actualizar, eliminar por matrícula y contar la cantidad de extintores por matrícula.
 *
 * @version 1.0
 */
package org.LittleBoat.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.LittleBoat.connection.ConnectionManager;
import org.LittleBoat.dto.ExtintoresDTO;

public class ExtintoresDAO {
    public static final Logger LOGGER = Logger.getLogger(ExtintoresDAO.class.getName());
    private final ConnectionManager connectionManager;

    public ExtintoresDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto ExtintoresDTO proporcionado en la tabla EXTINTORES de la
     * base de datos.
     *
     * @param extintor El objeto ExtintoresDTO que se va a guardar.
     * @return 1 si se pudo guadar con exito, -1 si no por algún fallo en la base de datos.
     */
    public int save(ExtintoresDTO extintor) {
        Connection connection = connectionManager.getConnection();
        String query = "INSERT INTO EXTINTORES (MATRICULA, FVIGENCIAEX, CANTIDAD) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement(query);
            statement.setInt(1, extintor.getMatricula());
            statement.setDate(2, java.sql.Date.valueOf(extintor.getFVigenciaEx()));
            statement.setInt(3, extintor.getCantidad());
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
     * Recupera una lista de objetos ExtintoresDTO de la tabla EXTINTORES basados en
     * la matrícula proporcionada.
     *
     * @param matricula La matrícula para filtrar extintores.
     * @return Una lista de objetos ExtintoresDTO correspondientes a la matrícula
     *         proporcionada.
     */
    public List<ExtintoresDTO> findByMatricula(Integer matricula) {
        ArrayList<ExtintoresDTO> extintores = new ArrayList<>();
        String query = "SELECT * FROM EXTINTORES WHERE MATRICULA = ?";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, matricula);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Date dateResult = resultSet.getDate("FVIGENCIAEX");
                LocalDate FVigenciaEx = dateResult.toLocalDate();

                int cantidad = resultSet.getInt("CANTIDAD");
                extintores.add(new ExtintoresDTO(matricula, FVigenciaEx, cantidad));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException exception) {
                LOGGER.log(Level.WARNING, exception.getSQLState());
            }
        }
        return extintores;
    }
    /**
     * Actualiza la fecha de vigencia y la cantidad de extintores de un
     * ExtintoresDTO en la tabla EXTINTORES basado en la matrícula proporcionada.
     *
     * @param extintor El objeto ExtintoresDTO con la información actualizada.
     * @return 1 si se pudo concretar la actualización, -1 si hubo algun fallo en la base de datos.
     */
    public int update(ExtintoresDTO extintor) {
        String query = "UPDATE EXTINTORES SET FVIGENCIAEX = ?, CANTIDAD = ? WHERE MATRICULA = ?";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            statement = connection.prepareStatement(query);
            statement.setDate(1, java.sql.Date.valueOf(extintor.getFVigenciaEx()));
            statement.setInt(2, extintor.getCantidad());
            statement.setInt(3, extintor.getMatricula());

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
     * Elimina un objeto ExtintoresDTO de la tabla EXTINTORES basado en la matrícula
     * proporcionada.
     *
     * @param matricula La matrícula del extintor a eliminar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByMatricula(int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM EXTINTORES WHERE MATRICULA = ?";
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
     * Cuenta la cantidad de extintores registrados para una matrícula dada en la
     * tabla EXTINTORES.
     *
     * @param matricula La matrícula para la cual se contará la cantidad de
     *                  extintores.
     * @return La cantidad de extintores registrados para la matrícula dada.
     */
    public int countAllByMatricula(int matricula) {
        int SIN_EXTINTOR = 0;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "SELECT COUNT(*) FROM EXTINTORES WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
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

        return SIN_EXTINTOR;
    }


}

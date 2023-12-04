/**
 * La clase MotoresDAO proporciona métodos de acceso a datos para interactuar con la tabla MOTORES en la base de datos.
 * Incluye métodos para guardar, buscar por matrícula, eliminar por matrícula, actualizar y buscar por matrícula y número de motor.
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

import org.littleboat.connection.ConnectionManager;
import org.littleboat.dto.MotoresDTO;

public class MotoresDAO {
    public static final Logger LOGGER = Logger.getLogger(ExtintoresDAO.class.getName());
    private final ConnectionManager connectionManager;

    public MotoresDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    /**
     * Guarda el objeto MotoresDTO proporcionado en la tabla MOTORES de la base de
     * datos.
     *
     * @param motor El objeto MotoresDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(MotoresDTO motor) {
        String query = "INSERT INTO MOTORES (MATRICULA, NOMOTOR, MARCA, POTENCIA_KW) VALUES (?, ?, ?, ?) ";

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            statement = connection.prepareStatement(query);
            statement.setInt(1, motor.getMatricula());
            statement.setInt(2, motor.getNoMotor());
            statement.setString(3, motor.getMarca());
            statement.setFloat(4, motor.getPotencia_KW());
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
     * Elimina un objeto MotoresDTO de la tabla MOTORES basado en la matrícula
     * proporcionada.
     *
     * @param matricula La matrícula del motor a eliminar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByMatricula(int matricula) {
        String query = "DELETE FROM MOTORES WHERE MATRICULA = ?";

        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;
        try  {
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
     * Actualiza la marca y la potencia del motor
     *
     * @param motor El objeto ExtintoresDTO con la información actualizada.
     * @return 1 si se pudo concretar la actualización, -1 si hubo algun fallo en la base de datos.
     */
    public int update(MotoresDTO motor) {
        String query = "UPDATE MOTORES SET MARCA = ?, POTENCIA_KW = ? WHERE MATRICULA = ? AND NOMOTOR = ?";

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            statement = connection.prepareStatement(query);
            statement.setInt(4, motor.getNoMotor());
            statement.setString(1, motor.getMarca());
            statement.setFloat(2, motor.getPotencia_KW());
            statement.setInt(3, motor.getMatricula());

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
     * Recupera una lista de objetos MotoresDTO de la tabla MOTORES basados en la
     * matrícula proporcionada.
     *
     * @param matricula La matrícula para la cual se buscarán los motores.
     * @return Una lista de objetos MotoresDTO correspondientes a la matrícula
     *         proporcionada.
     */
    public List<MotoresDTO> findByMatricula(int matricula) {
        List<MotoresDTO> motorsList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try  {
            String query = "SELECT MATRICULA, NOMOTOR, MARCA, POTENCIA_KW FROM MOTORES WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    MotoresDTO motor = new MotoresDTO();
                    motor.setMatricula(resultSet.getInt("MATRICULA"));
                    motor.setNoMotor(resultSet.getInt("NOMOTOR"));
                    motor.setMarca(resultSet.getString("MARCA"));
                    motor.setPotencia_KW(resultSet.getFloat("POTENCIA_KW"));
                    motorsList.add(motor);
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
        return motorsList;
    }


    /**
     * Recupera un objeto MotoresDTO de la tabla MOTORES basado en la matrícula y
     * número de motor proporcionados.
     *
     * @param matricula La matrícula del motor a buscar.
     * @param noMotor   El número de motor a buscar.
     * @return El objeto MotoresDTO correspondiente a la matrícula y número de motor
     *         proporcionados, o null si no se encuentra.
     */
    public MotoresDTO findByMatriculaAndNoMotor(int matricula, int noMotor) {
        String query = "SELECT MATRICULA, NOMOTOR, MARCA, POTENCIA_KW FROM MOTORES WHERE MATRICULA = ? AND NOMOTOR = ?";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            statement.setInt(2, noMotor);
            resultSet = statement.executeQuery();
            MotoresDTO motor = new MotoresDTO();
                if (resultSet.next()) {

                    motor.setMatricula(resultSet.getInt("MATRICULA"));
                    motor.setNoMotor(resultSet.getInt("NOMOTOR"));
                    motor.setMarca(resultSet.getString("MARCA"));
                    motor.setPotencia_KW(resultSet.getFloat("POTENCIA_KW"));
                    return motor;
                }
                return motor;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            return null;
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
    }
}

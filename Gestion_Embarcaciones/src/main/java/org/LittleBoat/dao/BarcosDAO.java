/**
 * La clase BarcosDAO proporciona métodos de acceso a datos para interactuar con la tabla BARCOS en la base de datos.
 * Incluye métodos para guardar, recuperar, actualizar y eliminar objetos BarcosDTO.
 *
 * @version 1.0
 */

package org.LittleBoat.dao;

import org.LittleBoat.connection.ConnectionManager;
import org.LittleBoat.dto.BarcosDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarcosDAO extends PaginDao{
    private final ConnectionManager connectionManager;
    public static final Logger LOGGER = Logger.getLogger(BarcosDAO.class.getName());

    public BarcosDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto BarcosDTO proporcionado en la tabla BARCOS de la base de
     * datos.
     *
     * @param barco El objeto BarcosDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(BarcosDTO barco) {

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;

        try  {

            String query = "INSERT INTO BARCOS (" +
                    "MATRICULA, NOMBARCO, CAPITANIAPUERTO, ESTADOBARCO, ARQUEOBRUTO_TONS, ARQUEONETO_TONS, " +
                    "ESLORA_MTS, MANGA_MTS, PUNTAL_MTS, IDPROP" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            statement = connection.prepareStatement(query);
            statement.setInt(1, barco.getMatricula());
            statement.setString(2, barco.getNomBarco());
            statement.setString(3, barco.getCapitaniaPuerto());
            statement.setString(4, barco.getEstadoBarco());
            statement.setFloat(5, barco.getArqueoBruto_Tons());
            statement.setFloat(6, barco.getArqueoNeto_Tons());
            statement.setFloat(7, barco.getEslora_Mts());
            statement.setFloat(8, barco.getManga_Mts());
            statement.setFloat(9, barco.getPuntual_Mts());
            statement.setInt(10, barco.getIdProp());
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
     * Recupera una lista de todos los objetos BarcosDTO de la tabla BARCOS.
     *
     * @return Una lista de objetos BarcosDTO.
     */
    public List<BarcosDTO> findAll() {

        ArrayList<BarcosDTO> barcos = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        Statement statement = null;
        try  {
            statement = connection.createStatement();
            String query = "SELECT * FROM BARCOS";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                barcos.add(
                        new BarcosDTO(
                                resultSet.getInt("MATRICULA"),
                                resultSet.getString("NOMBARCO"),
                                resultSet.getString("CAPITANIAPUERTO"),
                                resultSet.getString("ESTADOBARCO"),
                                resultSet.getFloat("ARQUEOBRUTO_TONS"),
                                resultSet.getFloat("ARQUEONETO_TONS"),
                                resultSet.getFloat("ESLORA_MTS"),
                                resultSet.getFloat("MANGA_MTS"),
                                resultSet.getFloat("PUNTAL_MTS"),
                                resultSet.getInt("IDPROP")));
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
        }
        return barcos;
    }

    /**
     * Recupera un objeto BarcosDTO de la tabla BARCOS basado en la matrícula
     * proporcionada.
     *
     * @param matricula La matrícula (ID) del Barco a recuperar.
     * @return El objeto BarcosDTO correspondiente a la matrícula proporcionada.
     */
    public BarcosDTO findByMatricula(int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM BARCOS WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            BarcosDTO barco = new BarcosDTO(
                    resultSet.getInt("MATRICULA"),
                    resultSet.getString("NOMBARCO"),
                    resultSet.getString("CAPITANIAPUERTO"),
                    resultSet.getString("ESTADOBARCO"),
                    resultSet.getFloat("ARQUEOBRUTO_TONS"),
                    resultSet.getFloat("ARQUEONETO_TONS"),
                    resultSet.getFloat("ESLORA_MTS"),
                    resultSet.getFloat("MANGA_MTS"),
                    resultSet.getFloat("PUNTAL_MTS"),
                    resultSet.getInt("IDPROP"));
            statement.close();
            return barco;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            e.printStackTrace();
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
     * Elimina un objeto BarcosDTO de la tabla BARCOS basado en la matrícula
     * proporcionada.
     *
     * @param matricula La matrícula (ID) del Barco a eliminar.
     * @return El número de filas afectadas en la base de datos, de no ser así devolverá -1.
     */
    public int deleteByMatricula(int matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String queryDeleteBarco = "DELETE FROM BARCOS WHERE MATRICULA = ?";
            statement = connection.prepareStatement(queryDeleteBarco);
            statement.setInt(1, matricula);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
     * Actualiza la información de un objeto BarcosDTO en la tabla BARCOS basado en
     * la matrícula proporcionada.
     *
     * @param barcosDTO El objeto BarcosDTO con la información actualizada.
     * @return El número de filas afectadas en la base de datos.
     */
    public int update(BarcosDTO barcosDTO) {

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {

            String query = "UPDATE BARCOS SET " +
                    "NomBarco = ?, CAPITANIAPUERTO = ?, ESTADOBARCO = ?, ARQUEOBRUTO_TONS = ?," +
                    "ARQUEONETO_TONS = ?, ESLORA_MTS = ?, MANGA_MTS = ?, PUNTAL_MTS = ?, IDPROP = ? "
                    + " WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, barcosDTO.getNomBarco());
            statement.setString(2, barcosDTO.getCapitaniaPuerto());
            statement.setString(3, barcosDTO.getEstadoBarco());
            statement.setFloat(4, barcosDTO.getArqueoBruto_Tons());
            statement.setFloat(5, barcosDTO.getArqueoNeto_Tons());
            statement.setFloat(6, barcosDTO.getEslora_Mts());
            statement.setFloat(7, barcosDTO.getManga_Mts());
            statement.setFloat(8, barcosDTO.getPuntual_Mts());
            statement.setInt(9, barcosDTO.getIdProp());
            statement.setInt(10, barcosDTO.getMatricula());

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
     * Recupera una lista de objetos BarcosDTO de la tabla BARCOS basados en el
     * idProp proporcionado.
     *
     * @param idProp El idProp para filtrar objetos BarcosDTO.
     * @return Una lista de objetos BarcosDTO correspondientes al idProp
     *         proporcionado.
     */
    public List<BarcosDTO> findByIdProp (int idProp) {
        List<BarcosDTO> barcosList = new ArrayList<>();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM BARCOS WHERE IDPROP = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idProp);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    BarcosDTO barcosDTO = new BarcosDTO(
                            resultSet.getInt("MATRICULA"),
                            resultSet.getString("NOMBARCO"),
                            resultSet.getString("CAPITANIAPUERTO"),
                            resultSet.getString("ESTADOBARCO"),
                            resultSet.getFloat("ARQUEOBRUTO_TONS"),
                            resultSet.getFloat("ARQUEONETO_TONS"),
                            resultSet.getFloat("ESLORA_MTS"),
                            resultSet.getFloat("MANGA_MTS"),
                            resultSet.getFloat("PUNTAL_MTS"),
                            resultSet.getInt("IDPROP"));
                    barcosList.add(barcosDTO);
                }
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
        }

        return barcosList;
    }
    /**
     * Elimina objetos BarcosDTO de la tabla BARCOS basados en el idProp
     * proporcionado.
     *
     * @param idProp El idProp para filtrar objetos BarcosDTO para la eliminación.
     * @return El número de filas afectadas en la base de datos, -1 si no se pudo realizar la acción.
     */
    public int deleteByIdProp (int idProp) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {
            String query = "DELETE FROM BARCOS WHERE IDPROP = ?";
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
     * Clase implementada para poder paginar registros de la tabla BARCOS
     * @param page el número de pagina para buscar los registros.
     * @return una lista de los registro de la tabla BARCOS según la pagina proporcionada.
     * */
    @Override
    public List<BarcosDTO> findPage(int page) {
        List<BarcosDTO> barcos = new ArrayList<>();
        Connection connection = this.connectionManager.getConnection();
        PreparedStatement statement = null;
        try  {

            String query = "SELECT * FROM BARCOS LIMIT ?  OFFSET  ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, this.getLimit());
            statement.setInt(2, calculateOffset(page));
            ResultSet resultSet = statement.executeQuery();

            while ( resultSet.next() ) {
                BarcosDTO barco = new BarcosDTO(
                        resultSet.getInt("MATRICULA"),
                        resultSet.getString("NOMBARCO"),
                        resultSet.getString("CAPITANIAPUERTO"),
                        resultSet.getString("ESTADOBARCO"),
                        resultSet.getFloat("ARQUEOBRUTO_TONS"),
                        resultSet.getFloat("ARQUEONETO_TONS"),
                        resultSet.getFloat("ESLORA_MTS"),
                        resultSet.getFloat("MANGA_MTS"),
                        resultSet.getFloat("PUNTAL_MTS"),
                        resultSet.getInt("IDPROP"));
                barcos.add(barco);
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
        return barcos;
    }

    /**
     * Clase implementada para contar los registros de la tabla BARCOS.
     * @return el número de registros detro de una tabla.
     * */
    @Override
    protected int countRecords() {
        Connection connection = this.connectionManager.getConnection();
        Statement statement = null;
        try  {
            String query = "SELECT COUNT(*) FROM BARCOS";
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

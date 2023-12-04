/**
 * La clase CertificadoCompetenciaDAO proporciona métodos de acceso a datos para interactuar con la tabla CERT_COMPETENCIA en la base de datos.
 * Incluye métodos para guardar, eliminar y actualizar objetos CertCompetenciaDTO, así como para buscar por folio, CURP o eliminar por CURP y folio.
 *
 * @version 1.0
 */
package org.littleboat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.littleboat.connection.ConnectionManager;
import org.littleboat.dto.CertCompetenciaDTO;

public class CertificadoCompetenciaDAO {
    private final ConnectionManager connectionManager;
    public static final Logger LOGGER = Logger.getLogger(CertificadoCompetenciaDAO.class.getName());

    public CertificadoCompetenciaDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto CertCompetenciaDTO proporcionado en la tabla
     * CERT_COMPETENCIA de la base de datos.
     *
     * @param certificado El objeto CertCompetenciaDTO que se va a guardar.
     * @return 1 si el registro fue exitoso, -1 si no.
     */
    public int save(CertCompetenciaDTO certificado) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO CERT_COMPETENCIA (FOLIO, CURP, FVIGENCIACC, CATEGORIA) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, certificado.getFolio());
            statement.setString(2, certificado.getCurp());
            statement.setDate(3, java.sql.Date.valueOf(certificado.getFExpiracion()));
            statement.setString(4, certificado.getCategoria());

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
     * Elimina un objeto CertCompetenciaDTO de la tabla CERT_COMPETENCIA basado en
     * el CURP proporcionado.
     *
     * @param curp El CURP del Certificado de Competencia a eliminar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByCurp(String curp) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM CERT_COMPETENCIA WHERE CURP = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, curp);

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
     * Elimina un objeto CertCompetenciaDTO de la tabla CERT_COMPETENCIA basado en
     * el folio proporcionado.
     *
     * @param folio El folio del Certificado de Competencia a eliminar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int deleteByFolio(String folio) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM CERT_COMPETENCIA WHERE FOLIO = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, folio);

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
     * Cambia los datos de una entidad folio en la base de datos, según la clave
     * primaria
     * especificada.
     *
     * @param certificado entidad con los nuevos valores a cambiar.
     * @return 1 si se pudo concretar el update -1 si no se logró.
     */
    public int updateByFolio(CertCompetenciaDTO certificado) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "UPDATE CERT_COMPETENCIA SET FVIGENCIACC = ?, CATEGORIA = ? WHERE FOLIO = ?";

            statement = connection.prepareStatement(query);
            statement.setDate(1, java.sql.Date.valueOf(certificado.getFExpiracion()));
            statement.setString(2, certificado.getCategoria());
            statement.setString(3, certificado.getFolio());

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
     * Recupera un objeto CertCompetenciaDTO de la tabla CERT_COMPETENCIA basado en
     * el folio proporcionado.
     *
     * @param folio El folio del Certificado de Competencia a buscar.
     * @return El objeto CertCompetenciaDTO correspondiente al folio proporcionado.
     */
    public CertCompetenciaDTO findByFolio(String folio) {
        String query = "SELECT * FROM CERT_COMPETENCIA WHERE FOLIO = ?";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, folio);
            ResultSet resultSet = statement.executeQuery();
            CertCompetenciaDTO certificado = new CertCompetenciaDTO();
            if (resultSet.next()) {

                certificado.setFolio(resultSet.getString("FOLIO"));
                certificado.setCurp(resultSet.getString("CURP"));
                certificado.setFExpiracion(resultSet.getDate("FVIGENCIACC").toLocalDate());
                certificado.setCategoria(resultSet.getString("CATEGORIA"));
            }
            return certificado;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
            this.connectionManager.closeConnection(connection);
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException exception) {
                LOGGER.log(Level.WARNING, e.getSQLState());
            }
        }
        return null;
    }

}

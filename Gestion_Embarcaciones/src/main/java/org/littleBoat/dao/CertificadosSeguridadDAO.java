/**
 * La clase CertificadosSeguridadDAO proporciona métodos de acceso a datos para interactuar con la tabla CERT_SEGURIDAD en la base de datos.
 * Incluye un método para guardar objetos CertSeguridadDTO y otro para buscar certificados por matrícula.
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
import org.littleboat.dto.CertSeguridadDTO;

public class CertificadosSeguridadDAO {
    private final ConnectionInterface connectionManager;
    private static final Logger LOGGER = Logger.getLogger(CertificadosSeguridadDAO.class.getName());

    public CertificadosSeguridadDAO(ConnectionInterface connectionManager) {
        this.connectionManager = connectionManager;
    }

    /**
     * Guarda el objeto CertSeguridadDTO proporcionado en la tabla CERT_SEGURIDAD de
     * la base de datos.
     *
     * @param certificado El objeto CertSeguridadDTO que se va a guardar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int save(CertSeguridadDTO certificado) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO CERT_SEGURIDAD (NOCERT, MATRICULA, LUGAREXPEDICION, FEXPEDICION, FVIGENCIACS) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, certificado.getNoCert());
            statement.setInt(2, certificado.getMatricula());
            statement.setString(3, certificado.getLugarExpedicion());
            statement.setDate(4, java.sql.Date.valueOf(certificado.getFExpedicion()));
            statement.setDate(5, java.sql.Date.valueOf(certificado.getFVigenciaCS()));

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
     * Recupera una lista de objetos CertSeguridadDTO de la tabla CERT_SEGURIDAD
     * basados en la matrícula proporcionada.
     *
     * @param matricula La matrícula para filtrar certificados de seguridad.
     * @return Una lista de objetos CertSeguridadDTO correspondientes a la matrícula
     *         proporcionada.
     */
    public List<CertSeguridadDTO> findByMatricula(Integer matricula) {
        List<CertSeguridadDTO> certificadosList = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM CERT_SEGURIDAD WHERE MATRICULA = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, matricula);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CertSeguridadDTO certificado = new CertSeguridadDTO();
                    certificado.setNoCert(resultSet.getString("NOCERT"));
                    certificado.setMatricula(resultSet.getInt("MATRICULA"));
                    certificado.setLugarExpedicion(resultSet.getString("LUGAREXPEDICION"));
                    certificado.setFExpedicion(resultSet.getDate("FEXPEDICION").toLocalDate());
                    certificado.setFVigenciaCS(resultSet.getDate("FVIGENCIACS").toLocalDate());
                    certificadosList.add(certificado);
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
        return certificadosList;
    }


    /**
     *Borra todas las entidades que compartan la matricula indicada
     * @param matricula La matrícula para filtrar certificados de seguridad.
     * @return el número de entidades que fueron borradas, -1 si hubo algun problema en la base de datos.
     */
    public int deleteByMatricula(Integer matricula) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM CERT_SEGURIDAD WHERE Matricula = ?";
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
     * Cambia los datos de una entidad folio en la base de datos, según la clave primaria
     * especificada.
     *
     * @param certificado entidad con los nuevos valores a cambiar.
     * @return 1 si se pudo concretar el update -1 si no se logró.
     */
    public int update(CertSeguridadDTO certificado) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "UPDATE CERT_SEGURIDAD SET LugarExpedicion = ?, FExpedicion = ?, FVigenciaCS = ? WHERE NoCert = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, certificado.getLugarExpedicion());
            statement.setDate(2, java.sql.Date.valueOf(certificado.getFExpedicion()));
            statement.setDate(3, java.sql.Date.valueOf(certificado.getFVigenciaCS()));
            statement.setString(4, certificado.getNoCert());

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
     * @param noCert El folio del Certificado de Competencia a buscar.
     * @return El objeto CertCompetenciaDTO correspondiente al folio proporcionado.
     */
    public int deleteByNoCert(String noCert) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM CERT_SEGURIDAD WHERE NoCert = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, noCert);

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

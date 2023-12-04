package org.littleboat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.*;
import org.littleboat.connection.H2Connection;
import org.littleboat.dto.PermisoPescaComDTO;
import org.littleboat.dto.TripulantesDTO;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {
    @BeforeAll
    static void persistenceDatabase() {
        String url = "jdbc:h2:mem:testdb";

        String userName = "sa";

        String password = "";
        try (Connection h2Connection = DriverManager.getConnection(url, userName, password)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    H2Connection instance = H2Connection.getInstance();

    CertificadoCompetenciaDAO certificadoCompetenciaDAO = new CertificadoCompetenciaDAO(instance);
    @Test
    @Order(1)
    void deleteCertificadosCompetencia(){
        int rowsAffected = certificadoCompetenciaDAO.deleteByCurp("KPOU753209QWERZX41");
        rowsAffected += certificadoCompetenciaDAO.deleteByCurp("WXTD938214IXYVHN62");
        Assertions.assertEquals(2, rowsAffected);
    }

    TripulantesDAO tripulantesDAO = new TripulantesDAO(instance);
    @Test
    @Order(2)
    void deleteTripulantes(){
        int rowsAffected = tripulantesDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(2, rowsAffected);
    }

    TipoPescaDAO tipoPescaDAO = new TipoPescaDAO(instance);
    @Test
    @Order(1)
    void deleteTiposPesca(){
        int rowsAffected = tipoPescaDAO.deleteByNoPermiso("724859631207");
        Assertions.assertEquals(2, rowsAffected);
    }

    PermisoPescaComDAO permisoPescaComDAO = new PermisoPescaComDAO(instance);
    @Test
    @Order(2)
    void deletePermisoPesca(){
        int rowsAffected = permisoPescaComDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(1, rowsAffected);
    }

    CertificadosSeguridadDAO seguridadDAO = new CertificadosSeguridadDAO(instance);
    @Test
    @Order(1)
    void deleteCertificadoSeguridad(){
        int rowsAffected = seguridadDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(1, rowsAffected);
    }

    ExtintoresDAO extintoresDAO = new ExtintoresDAO(instance);
    @Test
    @Order(1)
    void deleteExtintores(){
        int rowsAffected = extintoresDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(1, rowsAffected);
    }

    MotoresDAO motoresDAO = new MotoresDAO(instance);
    @Test
    @Order(1)
    void deleteMotores(){
        int rowsAffected = motoresDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(2, rowsAffected);
    }

    BarcosDAO barcosDAO = new BarcosDAO(instance);
    @Test
    @Order(3)
    void deleteBarco(){
        int rowsAffected = barcosDAO.deleteByMatricula(345678901);
        Assertions.assertEquals(1, rowsAffected);
    }

    EmbarcacionesDAO embarcacionesDAO = new EmbarcacionesDAO(instance);
    CertificadosSeguridadDAO certificadosSeguridadDAO = new CertificadosSeguridadDAO(instance);
    @Test
    @Order(4)
    void borrarUnBarcoTest () {
        int matricula = 654321087;
        Assertions.assertTrue(motoresDAO.deleteByMatricula(matricula) != -1);
        Assertions.assertTrue(extintoresDAO.deleteByMatricula(matricula) != -1);
        Assertions.assertTrue(embarcacionesDAO.deleteByMatricula(matricula) != -1);
        Assertions.assertTrue(certificadosSeguridadDAO.deleteByMatricula(matricula) != -1);

        List<TripulantesDTO> tripulantesDelBarco = tripulantesDAO.findByMatricula(matricula);

        for (TripulantesDTO tripulante : tripulantesDelBarco)  {
            Assertions.assertTrue(certificadoCompetenciaDAO.deleteByCurp(tripulante.getCurp()) != -1);
        }

        Assertions.assertTrue(tripulantesDAO.deleteByMatricula(matricula) != -1);

        List<PermisoPescaComDTO> permisosDelbarco = permisoPescaComDAO.findByMatricula(matricula);

        for (PermisoPescaComDTO permiso : permisosDelbarco) {
            Assertions.assertTrue(tipoPescaDAO.deleteByNoPermiso(permiso.getNoPermiso())!= -1);
        }

        Assertions.assertTrue(permisoPescaComDAO.deleteByMatricula(matricula) != -1);

        Assertions.assertTrue(barcosDAO.deleteByMatricula(matricula) != -1);
    }
}

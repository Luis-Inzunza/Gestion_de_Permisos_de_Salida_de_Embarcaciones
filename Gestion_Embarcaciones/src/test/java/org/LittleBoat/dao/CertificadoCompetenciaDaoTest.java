package org.LittleBoat.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.CertCompetenciaDTO;
import java.time.LocalDate;


public class CertificadoCompetenciaDaoTest {

    CertificadoCompetenciaDAO certificadoCompetenciaDAO = new CertificadoCompetenciaDAO(H2Connection.getInstance());

    @Test
    void testSave() {
        CertCompetenciaDTO certificado = new CertCompetenciaDTO("Folio1", "GFDS432109ZXCVBN56", LocalDate.now(), "Categoria1");
        int result = certificadoCompetenciaDAO.save(certificado);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testDeleteByCurp() {
        int rowsAffected = certificadoCompetenciaDAO.deleteByCurp("NBVC567890QWERTY41");
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void testDeleteByFolio() {

        int rowsAffected = certificadoCompetenciaDAO.deleteByFolio("0005432-B");
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void testUpdateByFolio() {

        CertCompetenciaDTO updatedCertificado = new CertCompetenciaDTO("SM00678901", "CURP3", LocalDate.now(), "CategoriaUpdated");
        int rowsAffected = certificadoCompetenciaDAO.updateByFolio(updatedCertificado);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void testFindByFolio() {

        CertCompetenciaDTO cetificadoCompetencia = certificadoCompetenciaDAO.findByFolio("0005432-B");
        Assertions.assertEquals("0005432-B", cetificadoCompetencia.getFolio());
    }
}
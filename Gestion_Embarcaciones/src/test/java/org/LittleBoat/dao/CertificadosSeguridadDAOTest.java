package org.LittleBoat.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.CertSeguridadDTO;

public class CertificadosSeguridadDAOTest {
    CertificadosSeguridadDAO certificadosSeguridadDAO = new CertificadosSeguridadDAO(H2Connection.getInstance());

    @Test
    void saveTest(){
        CertSeguridadDTO certSeguridadDTO = new CertSeguridadDTO(
            "DICM-059-0001", 900011122, "PROGRESO, YUCATÁN", LocalDate.parse("2023-04-15"), 
            LocalDate.parse("2024-04-15")
        );
        Assertions.assertEquals(1, certificadosSeguridadDAO.save(certSeguridadDTO));
    }

    @Test
    void findByMatriculaTest () {
        List<CertSeguridadDTO> certificados = certificadosSeguridadDAO.findByMatricula(900011122);

        Assertions.assertEquals(1, certificados.size());
    }

    @Test
    void deleteByNoCertTest () {
        int rowsAffected = certificadosSeguridadDAO.deleteByNoCert("DICM-059-0268");
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void deleteByMatricula () {
        int rowsAffected = certificadosSeguridadDAO.deleteByMatricula(765432123);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void updateTest () {
        CertSeguridadDTO certSeguridadDTO = new CertSeguridadDTO(
                "DICM-059-1234", 543210987, "IRAPUATO, GUANAJUATO", LocalDate.now(), LocalDate.now()
        );

        int rowsAffected = certificadosSeguridadDAO.update(certSeguridadDTO);

        Assertions.assertEquals(1, rowsAffected);
    }
}

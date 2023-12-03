package org.littleboat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.littleboat.connection.H2Connection;
import org.littleboat.dto.BarcosDTO;

public class BarcosDaoTest {

    @BeforeAll
    static void persistenceTatabase() {
        String url = "jdbc:h2:mem:testdb";

        String userName = "sa";

        String password = "";
        try (Connection h2Connection = DriverManager.getConnection(url, userName, password)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    BarcosDAO barcosDAO = new BarcosDAO(H2Connection.getInstance());

    @Test
    void testSave() {
        int result = barcosDAO.save(
                new BarcosDTO(
                        1, "Barco Test", "Capitanía del Pacífic, Sinaloa",
                        "Disponible", 52.0F, 41.6F, 21.5F, 8.8F, 5.7F, 6));
        Assertions.assertEquals(1, result);
    }
    
    @Test
    void SecondtestSave() {
        int result = barcosDAO.save(
                new BarcosDTO(
                        19, "Barco Test", "Capitanía del Pacífic, Sinaloa",
                        "Disponible", 52.0F, 41.6F, 21.5F, 8.8F, 5.7F, 19));
        Assertions.assertEquals(1, result);
    }

    @Test
    void deleteByMatriculaTest() {

        int rowsAffected = barcosDAO.deleteByMatricula(1);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void findByIdPropTest() {
        List<BarcosDTO> barcosList = barcosDAO.findByIdProp(16);
        Assertions.assertEquals(1, barcosList.size());
    }


    @Test
    void findAllTest() {
        List<BarcosDTO> barcosList = barcosDAO.findAll();
        Assertions.assertEquals(20, barcosList.size());
    }

    @Test
    void findByMatriculaTest() {
        BarcosDTO barco = barcosDAO.findByMatricula(121234567);
        Assertions.assertNotNull(barco);
    }

    @Test
    void updateTest() {
        BarcosDTO barcosDTO = new BarcosDTO(
            121234567, "HolandezHerrante", "Capitania de Cuba", "Inactivo", 150.0f, 120.0f, 35.0f, 12.0f, 6.0f, 6);
        int rowsAffected = barcosDAO.update(barcosDTO);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void testCount () {
        Assertions.assertEquals(20, barcosDAO.countRecords());
    }

    @Test
    void paginTest () {
        List<BarcosDTO> barcos = barcosDAO.findPage(2);
        System.out.println(barcos);
        Assertions.assertEquals(5, barcos.size());
    }
}

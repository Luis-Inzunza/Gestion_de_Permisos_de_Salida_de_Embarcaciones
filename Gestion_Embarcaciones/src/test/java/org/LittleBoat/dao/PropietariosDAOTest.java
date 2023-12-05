package org.LittleBoat.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.PropietariosDTO;

import java.util.List;

public class PropietariosDAOTest {
    PropietariosDAO propietariosDAO = new PropietariosDAO(H2Connection.getInstance());

    @Test
    void findAllTest () {
        List<PropietariosDTO> propietarios = propietariosDAO.findAll();
        Assertions.assertEquals(21, propietarios.size());
    }

    @Test
    void testSave(){
        PropietariosDTO propietario = new PropietariosDTO(
                null,"Alan", "Asp", "9986", "josuecanul@gmail.com",  true
        );
        Assertions.assertEquals(propietariosDAO.save(propietario), 1);
    }

    @Test
    void testFindElementById() {
        PropietariosDTO propietario = propietariosDAO.findByIdProp(1);
        Assertions.assertEquals(propietario.getNomProp(), "Juan");
    }

    @Test
    void updateTest () {
        PropietariosDTO propietario = new PropietariosDTO(
                21,"Alan", "Asp", "9986", "josuecanul90@gmail.com",  true
        );
        Assertions.assertEquals(1,propietariosDAO.update(propietario));
    }

    @Test
    void deleteElementByIdPropTest () {
        Assertions.assertEquals(1, propietariosDAO.deleteByIdProp(21));
    }


    @Test
    void countTest () {
        Assertions.assertEquals(20, propietariosDAO.countRecords());
    }

    @Test
    void paginTest () {
        Assertions.assertEquals(5, propietariosDAO.findPage(3).size());
    }


}

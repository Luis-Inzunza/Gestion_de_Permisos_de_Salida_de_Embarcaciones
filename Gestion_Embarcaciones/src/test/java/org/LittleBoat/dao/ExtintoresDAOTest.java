package org.LittleBoat.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.ExtintoresDTO;

public class ExtintoresDAOTest {
    ExtintoresDAO extintoresDAO = new ExtintoresDAO(H2Connection.getInstance());

    @Test
    void testInsert () {
        ExtintoresDTO extintoresDTO = new ExtintoresDTO(765432123, LocalDate.now(), 3);
        
        Assertions.assertEquals(1, extintoresDAO.save(extintoresDTO));
    }

    @Test
    void deleteTest () {
        Assertions.assertEquals(1, extintoresDAO.deleteByMatricula(121234567));
    }

    @Test
    void updateTest () {
        ExtintoresDTO extintoresDTO = new ExtintoresDTO(121234567, LocalDate.now(), 3);
        Assertions.assertEquals(1, extintoresDAO.update(extintoresDTO));
    }
    @Test
    void findByMatricula () {
        List <ExtintoresDTO> extintores = extintoresDAO.findByMatricula(900011122);
        Assertions.assertEquals(1, extintores.size());
    }
}

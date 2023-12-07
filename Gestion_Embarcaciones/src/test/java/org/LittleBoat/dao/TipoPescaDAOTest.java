package org.LittleBoat.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.TipoPescaDTO;

import java.util.List;

public class TipoPescaDAOTest {
    TipoPescaDAO tipoPescaDAO = new TipoPescaDAO(H2Connection.getInstance());
    @Test
    void testSave () {
        TipoPescaDTO tipoPesca = new TipoPescaDTO(
          "149235870632", 3, "Barracuda"
        );
        Assertions.assertEquals(1, tipoPescaDAO.save(tipoPesca));
    }
    @Test
    void testUpdate () {
        TipoPescaDTO tipoPesca = new TipoPescaDTO(
                "149235870632", 3, "Pez Espada"
        );
        Assertions.assertEquals(1, tipoPescaDAO.update(tipoPesca));
    }
    @Test
    void testFindByNoPermiso () {
        List<TipoPescaDTO> tipoPesca = tipoPescaDAO.findByNoPermiso("149235870632");
        Assertions.assertEquals(2, tipoPesca.size());
    }
    @Test
    void testdeleteByNoPermisoAndNoEspecie () {
        Assertions.assertEquals(1, tipoPescaDAO.deleteByNoPermisoAndNoEspecie("149235870632", 1));
    }

    @Test
    void testdeleteByNoPermiso () {
        Assertions.assertEquals(2, tipoPescaDAO.deleteByNoPermiso("365812094782"));
    }
}

package org.LittleBoat.dao;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.PermisoPescaComDTO;

public class PermisoPescaComDAOTest {

    PermisoPescaComDAO permisoDAO = new PermisoPescaComDAO(H2Connection.getInstance());

    @Test
    void testSave() {
        PermisoPescaComDTO permiso = new PermisoPescaComDTO();
        permiso.setNoPermiso("123ABC");
        permiso.setMatricula(121212121);
        permiso.setFVigenciaPPC(LocalDate.of(2023, 1, 1));

        int result = permisoDAO.save(permiso);
        Assertions.assertEquals(1, result);
    }
    @Test
    void testDeleteByNoPermiso () {
        int result = permisoDAO.deleteByNoPermiso("123ABC");
        Assertions.assertEquals(1, result);
    }

    @Test
    void testUpdateFechaVigencia() {
        PermisoPescaComDTO permiso = new PermisoPescaComDTO();
        permiso.setNoPermiso("106254793828");
        permiso.setMatricula(121212121);
        permiso.setFVigenciaPPC(LocalDate.of(2023, 12, 31));

        int rowsAffected = permisoDAO.updateFechaVigencia(permiso);
        Assertions.assertEquals(1, rowsAffected);
    }

    @Test
    void testFindByMatricula() {
        List<PermisoPescaComDTO> permisosList = permisoDAO.findByMatricula(121212121);
        Assertions.assertFalse(permisosList.isEmpty());
    }
}

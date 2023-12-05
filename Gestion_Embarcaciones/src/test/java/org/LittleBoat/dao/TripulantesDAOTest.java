package org.LittleBoat.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dto.TripulantesDTO;

public class TripulantesDAOTest {


    TripulantesDAO tripulantesDAO = new TripulantesDAO(H2Connection.getInstance());

    @Test
    void testSave() {
        TripulantesDTO tripulante = new TripulantesDTO();
        tripulante.setCurp("ABCD");
        tripulante.setNomTripulante("Daniel");
        tripulante.setApsTripulante("Méndez");
        tripulante.setMatricula(765432123);

        int rowsAffected = tripulantesDAO.save(tripulante);

        assertEquals(1, rowsAffected);
    }

    @Test
    void testFindByMatricula() {
        int testMatricula = 765432123;

        List<TripulantesDTO> tripulantesList = tripulantesDAO.findByMatricula(765432123);

        assertFalse(tripulantesList.isEmpty());

        TripulantesDTO tripulante = tripulantesList.get(0);

        assertNotNull(tripulante, "The retrieved tripulante should not be null.");

        assertEquals(testMatricula, tripulante.getMatricula(), "The matricula should match.");

        assertNotNull(tripulante.getCurp(), "The CURP should not be null.");
        assertNotNull(tripulante.getNomTripulante(), "The NOM_TRIPULANTE should not be null.");
        assertNotNull(tripulante.getApsTripulante(), "The APS_TRIPULANTE should not be null.");
    }



    @Test
    void testUpdate() {

    }

    @Test
    void testFindByCurp() {
        TripulantesDTO tripulante = tripulantesDAO.findByCurp("POIU876543LKJHGT21");

        assertNotNull(tripulante);
        assertEquals("POIU876543LKJHGT21", tripulante.getCurp());
    }

    @Test
    void testFindAll() {
        List<TripulantesDTO> tripulantesList = tripulantesDAO.findAll();

        assertFalse(tripulantesList.isEmpty());
    }
}

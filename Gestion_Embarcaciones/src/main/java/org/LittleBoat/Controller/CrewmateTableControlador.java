package org.LittleBoat.Controller;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.LittleBoat.View.CrewmatesTable;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dao.CertificadoCompetenciaDAO;
import org.LittleBoat.dao.TripulantesDAO;
import org.LittleBoat.dto.CertCompetenciaDTO;
import org.LittleBoat.dto.PropietariosDTO;
import org.LittleBoat.dto.TripulantesDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrewmateTableControlador {
    private CrewmatesTable crewmastesTable;
    private int matricula;

    public CrewmateTableControlador(CrewmatesTable crewmatesTable, int matricula) {
        this.crewmastesTable = crewmatesTable;
        this.matricula = matricula;
        crewmatesTable.setVisible(true);
        crewmatesTable.setEditButtonListener(new handlerEditar());
        crewmatesTable.setDeleteButtonListener(new handlerEliminar());
        DefaultTableModel model = (DefaultTableModel) crewmastesTable.getCrewmatesTable().getModel();
        model.addColumn("Curp");
        crewmastesTable.getCrewmatesTable().setModel(model);
        cargarTablaCrewmate();
    }

    public void cargarTablaCrewmate() {
        DefaultTableModel model = (DefaultTableModel) crewmastesTable.getCrewmatesTable().getModel();
        TripulantesDAO tripulantesDAO = new TripulantesDAO(H2Connection.getInstance());
        CertificadoCompetenciaDAO certificadoCompetenciaDAO = new CertificadoCompetenciaDAO(H2Connection.getInstance());
        ArrayList<TripulantesDTO> lista = (ArrayList<TripulantesDTO>) tripulantesDAO.findByMatricula(matricula);

        for (TripulantesDTO crewmate : lista) {
            String curp = crewmate.getCurp();
            CertCompetenciaDTO certCompetenciaDTO = certificadoCompetenciaDAO.findByCurp(curp);
            model.addRow(
                    new Object[] { crewmate.getNomTripulante(), certCompetenciaDTO.getCategoria(),
                            certCompetenciaDTO.getFExpiracion(), crewmate.getCurp() });
        }
        crewmastesTable.getCrewmatesTable().setModel(model);
    }

    public void borrarCrewmate() {
        int row = crewmastesTable.getCrewmatesTable().getSelectedRow();
        TripulantesDAO tripulantesDAO = new TripulantesDAO(H2Connection.getInstance());
        CertificadoCompetenciaDAO certificadoCompetenciaDAO = new CertificadoCompetenciaDAO(H2Connection.getInstance());
        String curp = (String) crewmastesTable.getCrewmatesTable().getValueAt(row, 3);
        tripulantesDAO.deleteByCurp(curp);
        certificadoCompetenciaDAO.deleteByCurp(curp);
        // cargarTablaCrewmate();
    }

    private class handlerEditar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class handlerEliminar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            borrarCrewmate();
        }
    }

}

package org.LittleBoat.Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.LittleBoat.View.CrewmatesTable;
import org.LittleBoat.View.Historial;
import org.LittleBoat.View.NavigationWindow;
import org.LittleBoat.View.NuevaEmbarcacion;
import org.LittleBoat.View.NuevoBarco;
import org.LittleBoat.View.NuevoPropetario;
import org.LittleBoat.View.OwnerTable;
import org.LittleBoat.View.ShipTable;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dao.BarcosDAO;
import org.LittleBoat.dao.PropietariosDAO;
import org.LittleBoat.dto.BarcosDTO;
import org.LittleBoat.dto.PropietariosDTO;

public class NavWDController {

    private NavigationWindow navigationWindow;
    private OwnerTable localOwnerTable;
    private ShipTable localShipTable;
    private JPanel localMutablePanel;
    private JTextField searchBar;
    private boolean isOwnerTable;
    private boolean isShipTable;

    public NavWDController(NavigationWindow inNavigationWindow) {
        navigationWindow = inNavigationWindow;
        localMutablePanel = navigationWindow.getMutablePanel();
        navigationWindow.setSearchButtonListener(new SearchButtonHandler());
        navigationWindow.setNewElementButtonListener(new NewElementButtonHandler());
        navigationWindow.setShipListButtonListener(new ShipTableButtonHandler());
        navigationWindow.setOwnerListButtonListener(new OwnerTableButtonHandler());
        navigationWindow.setCertificadeHistoryListener(new CertificateHistoryButtonHandler());
        navigationWindow.setFilterComboBoxListener(new FilterButtonHandler());
        navigationWindow.setCrewmatesButtonListener(new crewmatesButtonHandler());
        navigationWindow.setCertificadesButtonListener(new certificadesButtonHandler());
        navigationWindow.setEditButtonListener(new editButtonHandler());
        navigationWindow.setDeleteButtonListener(new deleteButtonHandler());
        localOwnerTable = new OwnerTable();
        localShipTable = new ShipTable();
        loadShipView();
        isOwnerTable = localMutablePanel.getComponent(0) instanceof OwnerTable;
        isShipTable =  localMutablePanel.getComponent(0) instanceof ShipTable;
        //checkTableInstance();
    }

    private void loadShipTableModel() {
        DefaultTableModel model = (DefaultTableModel) localShipTable.getShipTable().getModel();
        BarcosDAO barcosDAO = new BarcosDAO(H2Connection.getInstance());
        ArrayList<BarcosDTO> listabarcos = (ArrayList<BarcosDTO>) barcosDAO.findAll();
        for (BarcosDTO barco : listabarcos) {
            model.addRow(new Object[] { barco.getMatricula(), barco.getNomBarco(), barco.getCapitaniaPuerto(),
                    barco.getEstadoBarco() });
        }
        localShipTable.getShipTable().setModel(model);
    }

    private void loadOwnerTableModel() {
        DefaultTableModel model = (DefaultTableModel) localOwnerTable.getOwnerTable().getModel();
        PropietariosDAO propietariosDAO = new PropietariosDAO(H2Connection.getInstance());
        ArrayList<PropietariosDTO> listapPopietarios = (ArrayList<PropietariosDTO>) propietariosDAO.findAll();
        for (PropietariosDTO propietario : listapPopietarios) {
            model.addRow(
                    new Object[] {propietario.getIdProp() ,propietario.getNomProp() + " " + propietario.getApsProp(), propietario.getTelefono(),
                            propietario.getCorreo() });
        }
        localOwnerTable.getOwnerTable().setModel(model);
    }

    private void loadShipView() {
       // checkTableInstance();
        localShipTable.setSize(localMutablePanel.getSize());
        localShipTable.setLocation(0, 0);
        localMutablePanel.removeAll();
        loadShipTableModel();
        localMutablePanel.add(localShipTable, BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
        //checkTableInstance();
    }

    private void loadOwnerView() {
       // checkTableInstance();
        localOwnerTable.setSize(localMutablePanel.getSize());
        localOwnerTable.setLocation(0, 0);
        localMutablePanel.removeAll();
        loadOwnerTableModel();
        localMutablePanel.add(localOwnerTable, BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
       // checkTableInstance();
    }
    private void checkTableInstance(){
        if(isOwnerTable ==true)
             navigationWindow.getCrewmatesButton().setEnabled(isShipTable);
        else if(isShipTable == true)
            navigationWindow.getCertificadeButton().setEnabled(isOwnerTable);
    }  
    private class FilterButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("conecto al back y proyecto en la pagina segun el filtro el cual es");
            System.out.println(navigationWindow.getFilterComboBoxSelectedItem());
        }
    }

    private class SearchButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(navigationWindow.getSearchBarText());
        }
    }

    private class NewElementButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isOwnerTable==true) {
                NuevoPropetario newOwnerWindow = new NuevoPropetario();
                newOwnerWindowController newOwnerWindowController = new newOwnerWindowController(newOwnerWindow);
            } else if (isShipTable==true) {
                NuevoBarco newShipWindow = new NuevoBarco();
                newShipWindowController newShipWindowController = new newShipWindowController(newShipWindow);
            } else {
                System.out.println("error");
            }
        }
    }

    private class ShipTableButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cambiar el JPanel para mostrar la vista de barcos");
            loadShipView();
        }
    }

    private class OwnerTableButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cambiar el JPanel para mostrar la vista de propietarios");
            loadOwnerView();
        }
    }

    private class CertificateHistoryButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("desplegar la ventana de historial de embarcaciones");
            Historial historial = new Historial();
            historial.setVisible(true);
        }
    }
    private class crewmatesButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
           
                CrewmatesTable crewmatesTable = new CrewmatesTable();
                int matricula = conseguirMatriculaSelecionada();
                CrewmateTableControlador crewmateTableControlador = new CrewmateTableControlador(crewmatesTable,
                        matricula);
                crewmatesTable.setVisible(true);        
        }
        private int conseguirMatriculaSelecionada() {
            JTable shipTable = ((ShipTable) navigationWindow.getMutablePanel().getComponent(0)).getShipTable();
            int rowSelected = (shipTable.getSelectedRow());
            int matricula = (int) shipTable.getValueAt(rowSelected, 0);
            return matricula;
        }
    }
    private class certificadesButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            NuevaEmbarcacion nuevaEmbarcacion = new NuevaEmbarcacion();
            nuevaEmbarcacion.setVisible(true);
        }
    }
    private class editButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isOwnerTable){
                
                System.out.println("Edito datos de OwnerTable");
            }else if (isShipTable) {

                System.out.println("Editando ShipTable");
            } else {
                System.out.println("Tipo de panel desconocido");
            }
        }
    }
    private class deleteButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  

            if(isOwnerTable){
                System.out.println("borrando en owner table");
            }else if (isShipTable) {
                System.out.println("borrando en ship table");
            } else {
                System.out.println("Tipo de panel desconocido");
            }
        }
    }
    
}

package org.LittleBoat.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.LittleBoat.View.NavigationWindow;
import org.LittleBoat.View.OwnerTable;
import org.LittleBoat.View.ShipTable;

public class TableButtonsController {
private NavigationWindow localNavigationWindow;
private JPanel localMutablePanel;
private OwnerTable localOwnerList;
private ShipTable localShipList;

    public TableButtonsController(NavigationWindow iNavigationWindow){
        localNavigationWindow = iNavigationWindow;
        localMutablePanel = localNavigationWindow.getMutablePanel();
        localNavigationWindow.setCertificadesButtonListener(new certificadesButtonHandler());
        localNavigationWindow.setCrewmatesButtonListener(new crewmatesButtonHandler());
        localNavigationWindow.setEditButtonListener(new editButtonHandler());
        localNavigationWindow.setDeleteButtonListener(new deleteButtonHandler());
        localOwnerList = new OwnerTable();
        localShipList = new ShipTable();
    }

    private class certificadesButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            System.out.println("abro ventana de certificados de embarcacion");
        }
    }
    private class crewmatesButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            System.out.println("abro ventana de tripulantes");
        }
    }
    private class editButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(localMutablePanel.getComponent(0) instanceof OwnerTable){
                
                System.out.println("Edito datos de OwnerTable");
            }else if (localMutablePanel.getComponent(0) instanceof ShipTable) {
                
                System.out.println("Editando ShipTable");
            } else {
                // Tipo desconocido o tratamiento adicional si es necesario
                System.out.println("Tipo de panel desconocido");
            }
            System.out.println("abro ventana para crear lo que haya en la tabla pero en realidad edito");
        }
    }
    private class deleteButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            System.out.println("abro ventana para borrar lo que haya en la tabla");
        }
    }
}

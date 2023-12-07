package org.LittleBoat.Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.LittleBoat.View.Historial;
import org.LittleBoat.View.NavigationWindow;
import org.LittleBoat.View.NuevoBarco;
import org.LittleBoat.View.NuevoPropetario;
import org.LittleBoat.View.OwnerTable;
import org.LittleBoat.View.ShipTable;

public class NavWDController{
    
    private final NavigationWindow navigationWindow;
    private final OwnerTable localOwnerList;
    private final ShipTable localShipList;
    private JPanel localMutablePanel;
    private TableButtonsController tableButtonsController;
    private JTextField searchBar; //lo usare cuando le de al boton de busqueda

    public NavWDController(NavigationWindow inNavigationWindow/*,TableButtonsController in_TableButtonsController*/) {
        navigationWindow = inNavigationWindow;
        localMutablePanel = navigationWindow.getMutablePanel();
        tableButtonsController = new TableButtonsController(inNavigationWindow);
        navigationWindow.setSearchButtonListener(new SearchButtonHandler());
        navigationWindow.setNewElementButtonListener(new NewElementButtonHandler());
        navigationWindow.setShipListButtonListener(new ShipListButtonHandler());
        navigationWindow.setOwnerListButtonListener(new OwnerListButtonHandler());
        navigationWindow.setNewElementButtonListener(new NextButtonHandler());
        navigationWindow.setPrevButtonListener(new PrevButtonHandler());
        navigationWindow.setNextButtonListener(new NextButtonHandler());
        navigationWindow.setCertificadeHistoryListener(new CertificateHistoryButtonHandler());
        navigationWindow.setFilterComboBoxListener(new FilterButtonHandler());
        localOwnerList = new OwnerTable();
        localShipList = new ShipTable();
        loadOwnerView();
    }

    private void loadShipView() {
        localShipList.setSize(localMutablePanel.getSize());
        localShipList.setLocation(0, 0);
        localMutablePanel.removeAll();
        localMutablePanel.add(localShipList, BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
    }

    private void loadOwnerView() {
        localOwnerList.setSize(localMutablePanel.getSize());
        localOwnerList.setLocation(0, 0);
        localMutablePanel.removeAll();
        localMutablePanel.add(localOwnerList, BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
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
            System.out.println("tomo lo que hay en searchbar que es ");
            System.out.println(navigationWindow.getSearchBarText());
            System.out.println("ahora este dato lo meto como el nombre en una sentencia sql");
        }
    }

    private class NewElementButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("distinguir qué lista está activa y redirigir a la ventana correcta");
            if (localMutablePanel.getComponent(0) instanceof OwnerTable) {
                NuevoPropetario newOwnerWindow = new NuevoPropetario();
                newOwnerWindow.setVisible(true);
            } else if (localMutablePanel.getComponent(0) instanceof ShipTable) {
                NuevoBarco newShipWindow = new NuevoBarco();
                newShipWindow.setVisible(true);
            } else {
                System.out.println("error");
            }
        }
    }
    

    private class ShipListButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cambiar el JPanel para mostrar la vista de barcos");
            loadShipView();
        }
    }

    private class OwnerListButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cambiar el JPanel para mostrar la vista de propietarios");
            loadOwnerView();
        }
    }

    private class NextButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cambiar de página y cargar otra tanda de valores para mostrar");
        }
    }

    private class PrevButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("regresar una página y cargar esos valores para mostrar");
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
}

package org.littleboat.Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.littleboat.View.NavigationWindow;
import org.littleboat.View.OwnerTable;
import org.littleboat.View.ShipTable;

public class NavWDController{

    private final NavigationWindow navigationWindow;
    private final OwnerTable localOwnerList;
    private final ShipTable localShipList;
    private JPanel localMutablePanel;
    private JTextField searchBar; //lo usare cuando le de al boton de busqueda

    public NavWDController(NavigationWindow inNavigationWindow) {
        navigationWindow = inNavigationWindow;
        
        localMutablePanel = navigationWindow.getMutablePanel();
        navigationWindow.setSearchButtonListener(new SearchButtonHandler());
        navigationWindow.setNewElementButtonListener(new NewElementButtonHandler());
        navigationWindow.setShipListButtonListener(new ShipListButtonHandler());
        navigationWindow.setOwnerListButtonListener(new OwnerListButtonHandler());
        navigationWindow.setNewElementButtonListener(new NextButtonHandler());
        navigationWindow.setPrevButtonListener(new PrevButtonHandler());
        navigationWindow.setNextButtonListener(new NextButtonHandler());
        navigationWindow.setCertificadeHistoryListener(new CertificateHistoryButtonHandler());
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
            System.out.println("Abrir filtros");
        }
    }

    private class SearchButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("solicitar el dato mediante sentencia sql");
        }
    }

    private class NewElementButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("distinguir qué lista está activa y redirigir a la ventana correcta");
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
        }
    }
}

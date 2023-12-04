/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author samux
 */
public class NavWDController implements ActionListener{
    private final NavigationWindow NavigationWindow;
    private final OwnerTable localOwnerList;
    private final ShipTable localShipList;
    private JPanel localMutablePanel;
    private JTextField searchBar;
    private JButton certificadeHistoryButton;
    private JButton FilterBtn;
    private JButton newElementBtn;
    private JButton nextBtn;
    private JButton ownerListBtn;
    private JButton prevBtn;
    private JButton searchButton;
    private JButton shipListBtn;
    
    
    public NavWDController(NavigationWindow in_NavigationWindow){
        NavigationWindow = in_NavigationWindow;
        //ordenar por importancia no por orden alfabetico
        FilterBtn = NavigationWindow.getFilterBtn();
        FilterBtn.addActionListener(this);
        
        newElementBtn = NavigationWindow.getNewElementBtn();
        newElementBtn.addActionListener(this);
        
        nextBtn = NavigationWindow.getNextBtn();
        nextBtn.addActionListener(this);
        
        ownerListBtn = NavigationWindow.getOwnerListBtn();
        ownerListBtn.addActionListener(this);
        
        prevBtn = NavigationWindow.getPrevBtn();
        prevBtn.addActionListener(this);
        
        searchButton = NavigationWindow.getSearchButton();
        searchButton.addActionListener(this);
        
        shipListBtn = NavigationWindow.getShipListBtn();
        shipListBtn.addActionListener(this);
        
        certificadeHistoryButton = NavigationWindow.getCertificadeHistory();
        certificadeHistoryButton.addActionListener(this);

        localOwnerList = new OwnerTable();
        localShipList = new ShipTable();
        
        localMutablePanel = NavigationWindow.getMutablePanel();
        loadOwnerView();
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object navegationEvent = event.getSource();
        if(navegationEvent== FilterBtn){
            System.out.println("Abrir filtros");
        }if(navegationEvent== searchButton){
            System.out.println("solicitar el dato mediante sentencia sql");
        }if(navegationEvent==newElementBtn){
            System.out.println("distinguir que lista esta activa y redirigir a la ventana correcta");
        }if(navegationEvent==shipListBtn){
            System.out.println("cambiar el Jpanel para mostrar la vista de barcos");
            //localMutablePanel.removeAll();
            loadShipView();
            //buscar como cambiar la vista, revisar otra vez el tuto
        }if(navegationEvent==ownerListBtn){
            System.out.println("cambiar el jPanel para mostrar la vista de propietarios");
            localMutablePanel.removeAll();
            loadOwnerView();
        }if(navegationEvent==nextBtn){
            System.out.println("cambiar de pagina y cargar otra tanda de valores para mostrar");
        }if(navegationEvent==prevBtn){
            System.out.println("regresar una pagina y cargar esos valores para mostrar");
        }if(navegationEvent==certificadeHistoryButton){
            System.out.println("desplegar la ventana de historial de embarcaciones");
        }
    }
    private void loadShipView(){
        localShipList.setSize(localMutablePanel.getSize());
        localShipList.setLocation(0,0);
        localMutablePanel.removeAll();
        localMutablePanel.add(localOwnerList,BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
    }
    private void loadOwnerView(){
        localOwnerList.setSize(localMutablePanel.getSize());
        localOwnerList.setLocation(0,0);
        localMutablePanel.removeAll();
        localMutablePanel.add(localOwnerList,BorderLayout.CENTER);
        localMutablePanel.revalidate();
        localMutablePanel.repaint();
    }
    
}

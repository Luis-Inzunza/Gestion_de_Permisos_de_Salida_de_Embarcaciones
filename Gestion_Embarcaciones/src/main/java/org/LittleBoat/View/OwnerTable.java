/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LittleBoat.View;

import javax.swing.JTable;

/**
 *
 * @author samux
 */
public class OwnerTable extends javax.swing.JPanel {

    /**
     * Creates new form OwnerList
     */
    public OwnerTable() {
        initComponents();
        ButtonsType OwnerButtons = ButtonsType.BUTTONS_OWNER;
        TableActionEvent actionEvent = new TableActionEvent() {

            @Override
            public void onCertificadeButton(int row) {
                System.out.println("certificade en "+ row);
                NuevaEmbarcacion newEmbarcation = new NuevaEmbarcacion();
                newEmbarcation.setVisible(true);
            }

            @Override
            public void onCrewmateButton(int row) {
            }

            @Override
            public void onEditButton(int row) {
                System.out.println("edit en "+ row);
                NuevoPropetario newOwner = new NuevoPropetario();
                newOwner.setVisible(true);
            }

            @Override
            public void onDeleteButton(int row) {
                System.out.println("delete en "+ row);
                System.out.println("status de visibilidad setearlo a 0");
            }
            
        };
        //ownerTable.getColumnModel().getColumn(3).setCellRenderer(new InsertOwnerTableButtons());
        ownerTable.getColumnModel().getColumn(3).setCellRenderer(new TableButtonsRenderer(OwnerButtons));
        ownerTable.getColumnModel().getColumn(3).setCellEditor(new EditTableButtons(OwnerButtons,actionEvent));   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ownerTable = new javax.swing.JTable();

        ownerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "Phone Number", "Email", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ownerTable.setRowHeight(45);
        ownerTable.setSelectionBackground(new java.awt.Color(145, 186, 234));
        jScrollPane2.setViewportView(ownerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable ownerTable;
    // End of variables declaration//GEN-END:variables

    public JTable getOwnerTable() {
        return ownerTable;
    }
}

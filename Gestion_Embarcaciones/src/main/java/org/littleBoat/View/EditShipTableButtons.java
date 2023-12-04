/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.littleboat.View;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author samux
 */
public class EditShipTableButtons extends DefaultCellEditor {
    
    public EditShipTableButtons() {
        super(new JCheckBox());
    }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            ShipTableButtons btnSet = new ShipTableButtons();
            
            btnSet.setBackground(table.getSelectionBackground());
            return btnSet;

        }
}

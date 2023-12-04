/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.littleboat.View;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import org.littleboat.View.OwnerTableButtons;

/**
 *
 * @author samux
 */
public class EditCustomButton extends DefaultCellEditor{

        

        public EditCustomButton() {
        super(new JCheckBox());
    }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            OwnerTableButtons btnSet = new OwnerTableButtons();
            btnSet.setBackground(table.getSelectionBackground());
            return btnSet;

        }
}

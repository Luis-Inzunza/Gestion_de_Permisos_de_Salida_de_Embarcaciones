package org.littleboat.View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class InsertOwnerTableButtons extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component customButtonInsert = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        OwnerTableButtons ownerCustomButtons = new OwnerTableButtons();       
             if(isSelected==false){
           ownerCustomButtons.setBackground(Color.WHITE);
             }else
           customButtonInsert.getBackground();
             return ownerCustomButtons;
    }
}

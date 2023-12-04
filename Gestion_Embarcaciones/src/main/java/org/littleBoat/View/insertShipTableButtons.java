/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.littleboat.View;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.littleboat.View.ShipTableButtons;

/**
 *
 * @author samux
 */
public class insertShipTableButtons extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component customButtonInsert = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ShipTableButtons shipCustomButtons = new ShipTableButtons();     
             if(isSelected==false){
           shipCustomButtons.setBackground(Color.WHITE);
             }else
           customButtonInsert.getBackground();
             return shipCustomButtons;
    }
}

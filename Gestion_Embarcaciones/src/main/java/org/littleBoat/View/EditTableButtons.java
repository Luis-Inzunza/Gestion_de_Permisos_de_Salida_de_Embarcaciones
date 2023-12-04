package org.littleboat.View;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;

public class EditTableButtons extends DefaultCellEditor {

    private ButtonsType buttonsType;
    private TableActionEvent tableActionEvent;

    public EditTableButtons(ButtonsType buttonsType,TableActionEvent tableActionEvent) {
        super(new JCheckBox());
        this.buttonsType = buttonsType;
        this.tableActionEvent = tableActionEvent;
    }

    @Override
    public JComponent getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JPanel panel;

        switch (buttonsType) {
            case BUTTONS_OWNER:
            OwnerTableButtons ownerTableButtons = new OwnerTableButtons();
                ownerTableButtons.initEvent(tableActionEvent, row);
                panel = ownerTableButtons;
                break;
            case BUTTONS_SHIP:
            ShipTableButtons shipTableButtons = new ShipTableButtons();
                shipTableButtons.initEvent(tableActionEvent, row);
                panel = shipTableButtons;
                break;
            case BUTTONS_CREWMATE:
            CrewmatesTableButtons crewmatesTable = new CrewmatesTableButtons();
                crewmatesTable.initEvent(tableActionEvent, row);
                panel = crewmatesTable;
                break;
            default:
                panel = new JPanel();  // Otra clase por defecto si es necesario
        }

        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
}


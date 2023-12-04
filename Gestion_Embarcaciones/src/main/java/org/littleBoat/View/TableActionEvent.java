package org.littleboat.View;

public interface TableActionEvent {
    public void onCertificadeButton(int row);
    public void onCrewmateButton(int row);
    public void onEditButton(int row);
    public void onDeleteButton(int row);
}

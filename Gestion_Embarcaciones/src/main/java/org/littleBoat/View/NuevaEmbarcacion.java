/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.littleboat.View;

/**
 *
 * @author usuario
 */
public class NuevaEmbarcacion extends javax.swing.JFrame {

    /**
     * Creates new form NuevoBarco
     */
    public NuevaEmbarcacion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegisterBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ShipLabel = new javax.swing.JLabel();
        TypeFishingLabel = new javax.swing.JLabel();
        TypeFishingText = new javax.swing.JTextField();
        OutDateLabel = new javax.swing.JLabel();
        OutDateText = new javax.swing.JTextField();
        ReturDateLabel = new javax.swing.JLabel();
        ReturnDateText = new javax.swing.JTextField();
        DateFormatLabel = new javax.swing.JLabel();
        DateFormatLabel1 = new javax.swing.JLabel();
        NewShipBtn = new javax.swing.JButton();
        AnotherTypeBtn = new javax.swing.JButton();
        ShipComboBox = new javax.swing.JComboBox<>();
        ResetBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        TitleNewShip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(170, 234, 248));

        RegisterBtn.setBackground(new java.awt.Color(255, 255, 255));
        RegisterBtn.setForeground(new java.awt.Color(0, 0, 0));
        RegisterBtn.setText("Registrar");
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(232, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ShipLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ShipLabel.setForeground(new java.awt.Color(0, 0, 0));
        ShipLabel.setText("Barco :");

        TypeFishingLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TypeFishingLabel.setForeground(new java.awt.Color(0, 0, 0));
        TypeFishingLabel.setText("Tipo de Pesca :");

        TypeFishingText.setBackground(new java.awt.Color(255, 255, 255));
        TypeFishingText.setForeground(new java.awt.Color(0, 0, 0));
        TypeFishingText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeFishingTextActionPerformed(evt);
            }
        });

        OutDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OutDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        OutDateLabel.setText("Fecha de Salida :");

        OutDateText.setBackground(new java.awt.Color(255, 255, 255));
        OutDateText.setForeground(new java.awt.Color(0, 0, 0));
        OutDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutDateTextActionPerformed(evt);
            }
        });

        ReturDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ReturDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        ReturDateLabel.setText("Fecha de Regreso :");

        ReturnDateText.setBackground(new java.awt.Color(255, 255, 255));
        ReturnDateText.setForeground(new java.awt.Color(0, 0, 0));
        ReturnDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnDateTextActionPerformed(evt);
            }
        });

        DateFormatLabel.setForeground(new java.awt.Color(50, 50, 50));
        DateFormatLabel.setText("dd/mm/aaaa");

        DateFormatLabel1.setForeground(new java.awt.Color(50, 50, 50));
        DateFormatLabel1.setText("dd/mm/aaaa");

        NewShipBtn.setBackground(new java.awt.Color(255, 255, 255));
        NewShipBtn.setForeground(new java.awt.Color(0, 0, 0));
        NewShipBtn.setText("Nuevo Barco");
        NewShipBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewShipBtnActionPerformed(evt);
            }
        });

        AnotherTypeBtn.setBackground(new java.awt.Color(255, 255, 255));
        AnotherTypeBtn.setForeground(new java.awt.Color(0, 0, 0));
        AnotherTypeBtn.setText("+");
        AnotherTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnotherTypeBtnActionPerformed(evt);
            }
        });

        ShipComboBox.setBackground(new java.awt.Color(255, 255, 255));
        ShipComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ShipComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ShipComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShipComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(OutDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OutDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateFormatLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ReturDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ReturnDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateFormatLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TypeFishingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TypeFishingText, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnotherTypeBtn)))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ShipLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NewShipBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShipLabel)
                    .addComponent(ShipComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewShipBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OutDateLabel)
                    .addComponent(OutDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFormatLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturDateLabel)
                    .addComponent(ReturnDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFormatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeFishingLabel)
                    .addComponent(TypeFishingText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnotherTypeBtn))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        ResetBtn.setBackground(new java.awt.Color(255, 255, 255));
        ResetBtn.setForeground(new java.awt.Color(0, 0, 0));
        ResetBtn.setText("Limpiar");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        CancelBtn.setForeground(new java.awt.Color(0, 0, 0));
        CancelBtn.setText("Cancelar");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        TitleNewShip.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TitleNewShip.setForeground(new java.awt.Color(0, 0, 0));
        TitleNewShip.setText("Nueva Embarcación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CancelBtn)
                                .addGap(103, 103, 103)
                                .addComponent(ResetBtn))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(RegisterBtn)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(TitleNewShip)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleNewShip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBtn)
                    .addComponent(ResetBtn)
                    .addComponent(RegisterBtn))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }// GEN-LAST:event_CancelBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ResetBtnActionPerformed
        TypeFishingText.setText("");
        OutDateText.setText("");
    }// GEN-LAST:event_ResetBtnActionPerformed

    private void RegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RegisterBtnActionPerformed
        String nombreBarco = TypeFishingText.getText();
        String nombreCapitania = OutDateText.getText();
    }// GEN-LAST:event_RegisterBtnActionPerformed

    private void TypeFishingTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TypeFishingTextActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TypeFishingTextActionPerformed

    private void OutDateTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_OutDateTextActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_OutDateTextActionPerformed

    private void ReturnDateTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ReturnDateTextActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_ReturnDateTextActionPerformed

    private void NewShipBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_NewShipBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_NewShipBtnActionPerformed

    private void AnotherTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AnotherTypeBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_AnotherTypeBtnActionPerformed

    private void ShipComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ShipComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_ShipComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaEmbarcacion.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaEmbarcacion.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaEmbarcacion.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaEmbarcacion.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaEmbarcacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnotherTypeBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel DateFormatLabel;
    private javax.swing.JLabel DateFormatLabel1;
    private javax.swing.JButton NewShipBtn;
    private javax.swing.JLabel OutDateLabel;
    private javax.swing.JTextField OutDateText;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel ReturDateLabel;
    private javax.swing.JTextField ReturnDateText;
    private javax.swing.JComboBox<String> ShipComboBox;
    private javax.swing.JLabel ShipLabel;
    private javax.swing.JLabel TitleNewShip;
    private javax.swing.JLabel TypeFishingLabel;
    private javax.swing.JTextField TypeFishingText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

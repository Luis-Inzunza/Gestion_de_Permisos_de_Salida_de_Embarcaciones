package org.LittleBoat.Controller;

import org.LittleBoat.View.CaracteristicasBarco;
import org.LittleBoat.View.NuevoBarco;
import org.LittleBoat.View.NuevoPropetario;
import org.LittleBoat.dto.BarcosDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newShipWindowController {
    private NuevoBarco nuevoBarco;
    private BarcosDTO barcosDTO = new BarcosDTO();

    public newShipWindowController(NuevoBarco nuevoBarco) {
        this.nuevoBarco = nuevoBarco;
        nuevoBarco.anadirListenerCancelar(new handlerBotonCancelar());
        nuevoBarco.anadirListenerRegistrar(new handlerBotonRegistrar());
        nuevoBarco.anadirListenerlimpiar(new handlerBotonLimpiar());
        nuevoBarco.anadirListenerSiguiente(new handlerBotonSiguiente());
        nuevoBarco.setVisible(true);
    }

    private void limpiarCampos() {
        nuevoBarco.getIdText().setText("");
        nuevoBarco.getPortNameText().setText("");
        nuevoBarco.getShipNameText().setText("");
    }

    private void siguiente() {
        barcosDTO.setMatricula(Integer.parseInt(nuevoBarco.getIdText().getText()));
        barcosDTO.setNomBarco(nuevoBarco.getShipNameText().getText());
        barcosDTO.setCapitaniaPuerto(nuevoBarco.getPortNameText().getText());
        barcosDTO.setIdProp(nuevoBarco.getOwnerComboBox().getSelectedIndex() + 1);
        barcosDTO.setEstadoBarco("Disponible");

    }

    private class handlerBotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cerrando");
            nuevoBarco.dispose();
        }
    }

    private class handlerBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Limpiando");
            limpiarCampos();
        }
    }

    private class handlerBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Abriendo registro");
            NuevoPropetario newOwnerWindow = new NuevoPropetario();
            newOwnerWindowController newOwnerWindowController = new newOwnerWindowController(newOwnerWindow);
        }
    }

    private class handlerBotonSiguiente implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Siguiente");
            siguiente();
            CaracteristicasBarco caracteristicasBarco = new CaracteristicasBarco();
            CaracteristicasBarcoControlador caracteristicasBarcoControlador = new CaracteristicasBarcoControlador(
                    caracteristicasBarco, barcosDTO);
            nuevoBarco.dispose();
        }
    }
}

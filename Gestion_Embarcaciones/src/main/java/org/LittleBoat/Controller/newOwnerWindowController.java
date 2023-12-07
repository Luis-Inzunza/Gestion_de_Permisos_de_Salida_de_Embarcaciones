package org.LittleBoat.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.LittleBoat.View.NuevoPropetario;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dao.PropietariosDAO;
import org.LittleBoat.dto.PropietariosDTO;

public class newOwnerWindowController {
    private NuevoPropetario nuevoPropetario;

    public newOwnerWindowController(NuevoPropetario nuevoPropetario) {
        this.nuevoPropetario = nuevoPropetario;
        nuevoPropetario.anadirListenerCancelar(new handlerBotonCancelar());
        nuevoPropetario.anadirListenerRegistrar(new handlerBotonRegistrar());
        nuevoPropetario.anadirListenerlimpiar(new handlerBotonLimpiar());
        nuevoPropetario.setVisible(true);
    }

    private void limpiarCampos() {
        nuevoPropetario.getIdText().setText("");
        nuevoPropetario.getShipNameText().setText("");
        nuevoPropetario.getPortNameText().setText("");
        nuevoPropetario.getPortNameText1().setText("");
    }

    private void registrarPropietario() {
        String nombre = nuevoPropetario.getIdText().getText();
        String apellido = nuevoPropetario.getShipNameText().getText();
        String telefono = nuevoPropetario.getPortNameText().getText();
        String email = nuevoPropetario.getPortNameText1().getText();
        PropietariosDAO propietariosDAO = new PropietariosDAO(H2Connection.getInstance()); // CAMBIAR ESTO
        PropietariosDTO propietariosDTO = new PropietariosDTO(null, nombre, apellido, telefono, email, true);
        propietariosDAO.save(propietariosDTO);
    }

    private class handlerBotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cerrando");
            nuevoPropetario.dispose();
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
            System.out.println("Registrando");
            registrarPropietario();
        }
    }

}

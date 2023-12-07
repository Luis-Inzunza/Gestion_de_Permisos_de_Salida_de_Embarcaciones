package org.LittleBoat.Controller;

import org.LittleBoat.View.CaracteristicasBarco;
import org.LittleBoat.View.CertificadoSeguridad;
import org.LittleBoat.View.NuevoPropetario;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dao.BarcosDAO;
import org.LittleBoat.dao.CertificadosSeguridadDAO;
import org.LittleBoat.dao.ExtintoresDAO;
import org.LittleBoat.dao.MotoresDAO;
import org.LittleBoat.dto.BarcosDTO;
import org.LittleBoat.dto.CertSeguridadDTO;
import org.LittleBoat.dto.ExtintoresDTO;
import org.LittleBoat.dto.MotoresDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CertificadoSeguridadControlador {
    private CertificadoSeguridad certificadoSeguridad;
    private BarcosDTO barcosDTO;
    private MotoresDTO motoresDTO;
    private ExtintoresDTO extintoresDTO;
    private CertSeguridadDTO certSeguridadDTO = new CertSeguridadDTO();

    public CertificadoSeguridadControlador(CertificadoSeguridad certificadoSeguridad, BarcosDTO barcosDTO,
            MotoresDTO motoresDTO, ExtintoresDTO extintoresDTO) {
        this.certificadoSeguridad = certificadoSeguridad;
        this.barcosDTO = barcosDTO;
        this.motoresDTO = motoresDTO;
        this.extintoresDTO = extintoresDTO;
        certificadoSeguridad.anadirListenerCancelar(new handlerBotonCancelar());
        certificadoSeguridad.anadirListenerRegistrar(new handlerBotonRegistrar());
        certificadoSeguridad.anadirListenerlimpiar(new handlerBotonLimpiar());
        certificadoSeguridad.setVisible(true);
    }

    private void limpiarCampos() {
        certificadoSeguridad.getIdText().setText("");
        certificadoSeguridad.getPortNameText().setText("");
        certificadoSeguridad.getPortNameText1().setText("");
        certificadoSeguridad.getShipNameText().setText("");
    }

    private void siguienteCertificado() {
        certSeguridadDTO.setMatricula(barcosDTO.getMatricula());
        certSeguridadDTO.setNoCert(certificadoSeguridad.getIdText().getText());
        certSeguridadDTO.setLugarExpedicion(certificadoSeguridad.getShipNameText().getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        certSeguridadDTO.setFExpedicion(LocalDate.parse(certificadoSeguridad.getPortNameText().getText(), formatter));
        certSeguridadDTO.setFVigenciaCS(LocalDate.parse(certificadoSeguridad.getPortNameText1().getText(), formatter));
    }

    private void registrarBarco() {
        System.out.println(barcosDTO.toString());
        System.out.println(certSeguridadDTO.toString());
        System.out.println(motoresDTO.toString());
        System.out.println(extintoresDTO.toString());
        BarcosDAO barcosDAO = new BarcosDAO(H2Connection.getInstance());
        System.out.println(barcosDAO.save(barcosDTO));
        CertificadosSeguridadDAO certificadosSeguridadDAO = new CertificadosSeguridadDAO(H2Connection.getInstance());
        System.out.println(certificadosSeguridadDAO.save(certSeguridadDTO));
        MotoresDAO motoresDAO = new MotoresDAO(H2Connection.getInstance());
        System.out.println(motoresDAO.save(motoresDTO));
        ExtintoresDAO extintoresDAO = new ExtintoresDAO(H2Connection.getInstance());
        System.out.println(extintoresDAO.save(extintoresDTO));

    }

    private class handlerBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Limpiando");
            limpiarCampos();
        }
    }

    private class handlerBotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cerrando");
            certificadoSeguridad.dispose();
        }
    }

    private class handlerBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Registrando");
            siguienteCertificado();
            registrarBarco();
            certificadoSeguridad.dispose();
        }
    }
}

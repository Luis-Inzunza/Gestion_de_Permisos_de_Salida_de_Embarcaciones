package org.LittleBoat.Controller;

import org.LittleBoat.View.CaracteristicasBarco;
import org.LittleBoat.View.CertificadoSeguridad;
import org.LittleBoat.dto.BarcosDTO;
import org.LittleBoat.dto.ExtintoresDTO;
import org.LittleBoat.dto.MotoresDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CaracteristicasBarcoControlador {

    private CaracteristicasBarco caracteristicasBarco;
    private BarcosDTO barcosDTO;
    private MotoresDTO motoresDTO = new MotoresDTO();
    private ExtintoresDTO extintoresDTO = new ExtintoresDTO();

    public CaracteristicasBarcoControlador(CaracteristicasBarco caracteristicasBarco, BarcosDTO barcosDTO) {
        this.caracteristicasBarco = caracteristicasBarco;
        this.barcosDTO = barcosDTO;
        caracteristicasBarco.anadirListenerCancelar(new handlerBotonCancelar());
        caracteristicasBarco.anadirListenerSiguiente(new handlerBotonSiguiente());
        caracteristicasBarco.anadirListenerlimpiar(new handlerBotonLimpiar());
        caracteristicasBarco.setVisible(true);
    }

    private void limpiarCampos() {
        caracteristicasBarco.getMangaText().setText("");
        caracteristicasBarco.getMarcaText().setText("");
        caracteristicasBarco.getAmountText().setText("");
        caracteristicasBarco.getEsloraText().setText("");
        caracteristicasBarco.getPuntalText().setText("");
        caracteristicasBarco.getPotenciaText().setText("");
        caracteristicasBarco.getNetTonnageText().setText("");
        caracteristicasBarco.getGrossTonnageText().setText("");
        caracteristicasBarco.getExpeditionDateText().setText("");
    }

    private void siguienteBarco() {
        barcosDTO.setArqueoBruto_Tons(Float.parseFloat(caracteristicasBarco.getNetTonnageText().getText()));
        barcosDTO.setArqueoNeto_Tons(Float.parseFloat(caracteristicasBarco.getNetTonnageText().getText()));
        barcosDTO.setEslora_Mts(Float.parseFloat(caracteristicasBarco.getEsloraText().getText()));
        barcosDTO.setManga_Mts(Float.parseFloat(caracteristicasBarco.getMangaText().getText()));
        barcosDTO.setPuntual_Mts(Float.parseFloat(caracteristicasBarco.getPuntalText().getText()));
    }

    private void siguienteMotor() {
        motoresDTO.setMarca(caracteristicasBarco.getMarcaText().getText());
        motoresDTO.setMatricula(barcosDTO.getMatricula());
        motoresDTO.setNoMotor(1);
        motoresDTO.setPotencia_KW(Float.parseFloat(caracteristicasBarco.getPotenciaText().getText()));
    }

    private void siguienteExtintor() {
        extintoresDTO.setCantidad(Integer.parseInt(caracteristicasBarco.getAmountText().getText()));
        extintoresDTO.setMatricula(barcosDTO.getMatricula());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        extintoresDTO
                .setFVigenciaEx(LocalDate.parse(caracteristicasBarco.getExpeditionDateText().getText(), formatter));
    }

    private class handlerBotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cerrando");
            caracteristicasBarco.dispose();
        }
    }

    private class handlerBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Limpiando");
            limpiarCampos();
        }
    }

    private class handlerBotonSiguiente implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Siguiente");
            siguienteBarco();
            siguienteMotor();
            siguienteExtintor();
            CertificadoSeguridad certificadoSeguridad = new CertificadoSeguridad();
            CertificadoSeguridadControlador certificadoSeguridadControlador = new CertificadoSeguridadControlador(
                    certificadoSeguridad, barcosDTO, motoresDTO, extintoresDTO);

            caracteristicasBarco.dispose();
        }
    }
}

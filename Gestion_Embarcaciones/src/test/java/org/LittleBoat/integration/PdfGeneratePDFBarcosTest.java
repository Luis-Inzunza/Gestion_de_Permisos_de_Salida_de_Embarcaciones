package org.LittleBoat.integration;

import org.LittleBoat.connection.ConnectionManager;
import org.LittleBoat.connection.H2Connection;
import org.LittleBoat.dao.*;
import org.LittleBoat.dto.*;
import org.LittleBoat.report.PDFGenerator;
import org.LittleBoat.report.GenerateData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PdfGeneratePDFBarcosTest {
    ConnectionManager connectionManager = H2Connection.getInstance();
    BarcosDAO barcosDAO = new BarcosDAO(connectionManager);
    PropietariosDAO propietariosDAO = new PropietariosDAO(connectionManager);
    CertificadosSeguridadDAO certificadosSeguridadDAO = new CertificadosSeguridadDAO(connectionManager);
    PermisoPescaComDAO permisoPescaComDAO = new PermisoPescaComDAO(connectionManager);
    TipoPescaDAO tipoPescaDAO = new TipoPescaDAO(connectionManager);
    MotoresDAO motoresDAO = new MotoresDAO(connectionManager);

    ExtintoresDAO extintoresDAO = new ExtintoresDAO(connectionManager);
    TripulantesDAO tripulantesDAO = new TripulantesDAO(connectionManager);
    EmbarcacionesDAO embarcacionesDAO = new EmbarcacionesDAO(connectionManager);

    @Test
    void generateBarcosData () {
        int matricula = 654321087;
        EmbarcacionesDTO embarcacionesDTO = new EmbarcacionesDTO(654321087, LocalDate.now(), LocalDate.now());
        embarcacionesDAO.save(embarcacionesDTO);

        BarcosDTO barco = barcosDAO.findByMatricula(matricula);

        PropietariosDTO propietario = propietariosDAO.findByIdProp(barco.getIdProp());

        CertSeguridadDTO certSeguridadDTO = certificadosSeguridadDAO.findByMatricula(matricula).get(0);

        PermisoPescaComDTO permisoPescaCom = permisoPescaComDAO.findByMatricula(matricula).get(0);

        TipoPescaDTO tipoPesca = tipoPescaDAO.findByNoPermiso(permisoPescaCom.getNoPermiso()).get(0);

        MotoresDTO motor = motoresDAO.findByMatricula(matricula).get(0);

        ExtintoresDTO extintor = extintoresDAO.findByMatricula(matricula).get(0);

        TripulantesDTO tripulante = tripulantesDAO.findByMatricula(matricula).get(0);

        GenerateData generateData = new GenerateData(
                barco, propietario, certSeguridadDTO, permisoPescaCom,
                tipoPesca, motor, extintor, tripulante, embarcacionesDTO
        );

        generateData.generateCSV();

        PDFGenerator generarPDF = new PDFGenerator();
        generarPDF.generarPDF();
    }
}

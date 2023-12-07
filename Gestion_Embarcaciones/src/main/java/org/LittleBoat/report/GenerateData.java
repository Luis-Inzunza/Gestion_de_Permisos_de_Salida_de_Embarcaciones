package org.LittleBoat.report;

import lombok.AllArgsConstructor;
import org.LittleBoat.dto.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@AllArgsConstructor
public class GenerateData {

    private BarcosDTO barco;

    private PropietariosDTO propietario;

    private CertSeguridadDTO certificado;

    private PermisoPescaComDTO permisoPescaCom;

    private TipoPescaDTO tipoPesca;

    private MotoresDTO motor;

    private ExtintoresDTO extintores;

    private TripulantesDTO tripulantesDTO;

    private EmbarcacionesDTO embarcacion;


    public final String labels =
            "NomBarco;Matricula;CapitaniaPuerto;ArqueoBruto_Tons;NomProp;ApsProp;" +
                    "Matricula;LugarExpedicion;FExpedicion;FVigenciaCS;FSalida;Especie;Eslora_Mts;" +
                    "Manga_Mts;Marca;Potencia_KW;NoPermiso;Especie;FVigenciaPPC;NomProp;ApsProp;" +
                    "Cantidad;FVigenciaEx;NomTripulante;ApsTripulante;NomBarco;NomBarco";

    private String generateFields() {
        return barco.getNomBarco() + ";" + barco.getMatricula() + ";" + barco.getCapitaniaPuerto() + ";"
                + barco.getArqueoBruto_Tons() + ";" + propietario.getNomProp() + ";" + propietario.getApsProp() + ";" +
                barco.getMatricula() + ";" + certificado.getLugarExpedicion() + ";" + certificado.getFExpedicion() + ";" +
                permisoPescaCom.getFVigenciaPPC() + ";" + embarcacion.getFSalida() + ";" + tipoPesca.getEspecie() + ";" +
                barco.getEslora_Mts() + ";" + barco.getManga_Mts() + ";" + motor.getMarca() + ";" +
                motor.getPotencia_KW() + ";" + permisoPescaCom.getNoPermiso() + ";" + tipoPesca.getEspecie() + ";" +
                permisoPescaCom.getFVigenciaPPC() + ";" + propietario.getNomProp() + ";" + propietario.getApsProp() + ";" +
                extintores.getCantidad() + ";" + extintores.getFVigenciaEx() + ";" + tripulantesDTO.getNomTripulante() + ";" +
                tripulantesDTO.getApsTripulante() + ";" + barco.getNomBarco() + ";" + barco.getNomBarco();
    }

    public void generateCSV () {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/main/resources/reportFiles/data.txt"));
            printWriter.println(labels);
            printWriter.println(generateFields());
            printWriter.close();
        } catch (IOException e) {
            System.out.println();
        }

    }
}

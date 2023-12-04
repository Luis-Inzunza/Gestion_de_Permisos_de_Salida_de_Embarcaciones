package org.littleboat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarcosDTO {
    // PK
    private int matricula;
    // FK
    private String nomBarco;
    private String capitaniaPuerto;
    private String estadoBarco;
    private float arqueoBruto_Tons;
    private float arqueoNeto_Tons;
    private float eslora_Mts;
    private float manga_Mts;
    private float puntual_Mts;
    private int idProp;
}
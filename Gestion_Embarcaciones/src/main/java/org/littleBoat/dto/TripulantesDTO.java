package org.littleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripulantesDTO {
    //PK
    private String curp;
    //FK
    private String NomTripulante;
    private String apsTripulante;
    private int matricula;
}


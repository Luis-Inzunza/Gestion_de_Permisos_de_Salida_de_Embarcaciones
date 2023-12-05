package org.LittleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbarcacionesDTO {
    // PK,FK
    private int matricula;
    // PK
    private LocalDate fSalida;
    // FK
    private LocalDate fRegreso;
}

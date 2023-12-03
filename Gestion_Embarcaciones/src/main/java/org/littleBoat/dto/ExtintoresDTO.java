package org.littleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtintoresDTO {
    //PK,FK
    private Integer matricula;
    //PK
    private LocalDate fVigenciaEx;
    //FK
    private int cantidad;
}

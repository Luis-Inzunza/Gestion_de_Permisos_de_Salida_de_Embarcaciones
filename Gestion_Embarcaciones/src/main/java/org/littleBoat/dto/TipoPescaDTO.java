package org.littleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPescaDTO {
    // PK,FK
    private String noPermiso;
    // PK
    private int noEspecie;
    // FK
    private String especie;
}

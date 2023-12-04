package org.littleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoresDTO {
    // PK,FK
    private int matricula;
    // PK
    private int noMotor;
    // FK
    private String marca;
    private float potencia_KW;
}

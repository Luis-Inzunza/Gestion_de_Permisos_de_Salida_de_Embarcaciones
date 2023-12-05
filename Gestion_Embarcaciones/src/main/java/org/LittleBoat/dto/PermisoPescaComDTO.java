package org.LittleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermisoPescaComDTO {
    // PK
    private String noPermiso;
    // FK
    private int matricula;
    private LocalDate fVigenciaPPC;
}

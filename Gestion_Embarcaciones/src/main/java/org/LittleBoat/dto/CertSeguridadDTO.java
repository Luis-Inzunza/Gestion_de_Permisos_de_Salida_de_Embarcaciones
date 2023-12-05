package org.LittleBoat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertSeguridadDTO {
    // PK
    private String noCert;
    // FK
    private int matricula;
    private String lugarExpedicion;
    private LocalDate fExpedicion;
    private LocalDate fVigenciaCS;
}

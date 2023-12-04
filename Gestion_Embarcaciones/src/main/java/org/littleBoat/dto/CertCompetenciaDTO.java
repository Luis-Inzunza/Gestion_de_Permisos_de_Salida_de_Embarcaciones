package org.littleboat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertCompetenciaDTO {
    // PK
    private String folio;
    // FK
    private String curp;
    private LocalDate fExpiracion;
    private String categoria;
}

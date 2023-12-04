package org.littleboat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietariosDTO {
    // PK
    private Integer idProp;
    // FK
    private String nomProp;
    private String apsProp;
    private String telefono;
    private String correo;
    private Boolean estadoProp;
}

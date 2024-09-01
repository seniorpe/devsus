package pe.senior.rest.people.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;    
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;
}

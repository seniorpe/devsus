package pe.senior.rest.people.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteEntity {
    @Id
    private Long id;
    
    private String contrasena;
    private Boolean estado;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id", unique = true)
    private PersonaEntity persona;
}


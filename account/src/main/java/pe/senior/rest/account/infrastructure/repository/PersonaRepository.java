package pe.senior.rest.account.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.senior.rest.account.domain.entity.PersonaEntity;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
        Optional<PersonaEntity> findByNombre(@Param("nombre") String nombre);
}
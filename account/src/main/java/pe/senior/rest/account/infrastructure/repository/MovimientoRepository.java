package pe.senior.rest.account.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    @Query("SELECT m FROM MovimientoEntity m JOIN m.cuenta c WHERE m.fecha BETWEEN :fechaInicio AND :fechaFin AND c.cliente.persona.nombre = :cliente")
    List<MovimientoEntity> findByFechaBetweenAndCliente(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("cliente") String cliente
    );
}
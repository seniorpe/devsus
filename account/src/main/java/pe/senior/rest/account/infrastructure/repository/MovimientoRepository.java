package pe.senior.rest.account.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.senior.rest.account.domain.entity.MovimientoEntity;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

    /*@Query("SELECT m FROM MovimientoEntity m JOIN m.cuenta c WHERE m.fecha BETWEEN :fechaInicio AND :fechaFin AND c.cliente.id = :clienteId")
    List<MovimientoEntity> findByFechaBetweenAndClienteId(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("clienteId") Long clienteId
    );*/
}
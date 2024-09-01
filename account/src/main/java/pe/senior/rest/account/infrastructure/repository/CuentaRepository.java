package pe.senior.rest.account.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.senior.rest.account.domain.entity.CuentaEntity;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

}
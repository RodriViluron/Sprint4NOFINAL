package com.Spring3Pimienta.Spring4.repositories;

import com.Spring3Pimienta.Spring4.entities.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion,Long> {
}

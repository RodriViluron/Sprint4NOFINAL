package com.Spring3Pimienta.Spring4.repositories;

import com.Spring3Pimienta.Spring4.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

package com.Spring3Pimienta.Spring4.repositories;

import com.Spring3Pimienta.Spring4.entities.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto,Long> {
}

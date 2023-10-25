package com.Spring3Pimienta.Spring4.repositories;
import com.Spring3Pimienta.Spring4.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}

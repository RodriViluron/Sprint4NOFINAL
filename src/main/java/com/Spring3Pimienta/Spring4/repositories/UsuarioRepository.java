package com.Spring3Pimienta.Spring4.repositories;

import com.Spring3Pimienta.Spring4.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

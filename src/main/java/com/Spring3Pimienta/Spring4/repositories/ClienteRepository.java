package com.Spring3Pimienta.Spring4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Spring3Pimienta.Spring4.entities.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Anotacion Metodo de Query

    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros indexados
    /*@Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Cliente> search(String filtro);*/

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Cliente> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    //Nativas
    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            countQuery = "SELECT count (*) FROM cliente",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}

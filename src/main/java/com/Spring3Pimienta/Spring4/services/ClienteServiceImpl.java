package com.Spring3Pimienta.Spring4.services;

import com.Spring3Pimienta.Spring4.entities.Cliente;
import com.Spring3Pimienta.Spring4.repositories.BaseRepository;
import com.Spring3Pimienta.Spring4.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try{
            //List<Cliente> clientes = clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Cliente> clientes = clienteRepository.search(filtro);
            List<Cliente> clientes = clienteRepository.searchNativo(filtro);
            return clientes;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Cliente> clientes = clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            Page<Cliente> clientes = clienteRepository.searchNativo(filtro, pageable);
            return clientes;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

package com.Spring3Pimienta.Spring4.services;

import com.Spring3Pimienta.Spring4.entities.Domicilio;
import com.Spring3Pimienta.Spring4.repositories.BaseRepository;
import com.Spring3Pimienta.Spring4.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }
}

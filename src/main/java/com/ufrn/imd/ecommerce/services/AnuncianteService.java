package com.ufrn.imd.ecommerce.services;

import com.ufrn.imd.ecommerce.models.Anunciante;
import com.ufrn.imd.ecommerce.repositories.AnuncianteRepository;
import org.springframework.stereotype.Service;

@Service
public class AnuncianteService {
    private final AnuncianteRepository anuncianteRepository;

    public AnuncianteService(AnuncianteRepository anuncianteRepository) {
        this.anuncianteRepository = anuncianteRepository;
    }

    public void createUsuario(Anunciante usuario) {
        // to-do validações para criação do usuário;
        anuncianteRepository.save(usuario);
    }


}

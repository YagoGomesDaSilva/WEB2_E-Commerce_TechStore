package com.ufrn.imd.ecommerce.services;

import com.ufrn.imd.ecommerce.models.UsuarioAbstrato;
import com.ufrn.imd.ecommerce.models.UsuarioConcreto;
import com.ufrn.imd.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioConcreto findUsuario(Long idUsuario) throws Exception {
        UsuarioConcreto usuario = usuarioRepository.findById(idUsuario).isPresent() ? usuarioRepository.findById(idUsuario).get() : null;
        if (usuario == null){
            throw new Exception();
        }
        return usuario;
    }

    public void createUsuario(UsuarioConcreto usuario) {
        // to-do validações para criação do usuário;
        usuarioRepository.save(usuario);
    }


    public UsuarioAbstrato authenticate(String email, String senha){
        // Buscar o usuário pelo email
        UsuarioAbstrato usuario = usuarioRepository.findByEmail(email);

        // Verificar se o usuário foi encontrado e se a senha corresponde
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario; // Retorna o usuário autenticado
        } else {
            return null; // Retorna null se a autenticação falhar
        }
    }


}

package com.ufrn.imd.ecommerce.controllers;

import com.ufrn.imd.ecommerce.models.Anunciante;
import com.ufrn.imd.ecommerce.models.UsuarioAbstrato;
import com.ufrn.imd.ecommerce.models.UsuarioConcreto;
import com.ufrn.imd.ecommerce.services.AnuncianteService;
import com.ufrn.imd.ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AnuncianteService anuncianteService;

    @GetMapping("/")
    public String showLoginForm() {
        return "autenticacao/login"; // Retorna o nome do arquivo HTML (login.html)
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model) {
        UsuarioAbstrato usuario = usuarioService.authenticate(email, senha);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "redirect:/principal/dashboard"; // Redireciona para a página de dashboard após o login
        } else {
            model.addAttribute("error", "Credenciais inválidas. Tente novamente.");
            return "autenticacao/login"; // Redireciona de volta para o formulário de login com mensagem de erro
        }
    }

    @GetMapping("/autenticacao/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("usuario", new UsuarioConcreto());
        model.addAttribute("anunciante", new Anunciante());
        return "autenticacao/signup"; // Retorna o nome do arquivo HTML (signup.html)
    }

    @PostMapping("/autenticacao/signup")
    public String signup(@ModelAttribute("usuario") UsuarioConcreto usuario,
                         @ModelAttribute("anunciante") Anunciante anunciante,
                         Model model) {
        if (usuario.isTipo()) {
            usuarioService.createUsuario(usuario);
        } else {
            anuncianteService.createUsuario(anunciante); // Corrigido para createAnunciante
        }
        return "redirect:/login"; // Redireciona para a página de login após o cadastro
    }
}

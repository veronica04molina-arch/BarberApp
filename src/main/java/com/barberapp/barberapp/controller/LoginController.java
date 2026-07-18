package com.barberapp.barberapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberapp.barberapp.model.Usuario;
import com.barberapp.barberapp.service.UsuarioService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
/**
 * Controlador encargado del proceso de autenticación
 * de los usuarios del sistema.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    /**
 * Valida las credenciales de acceso del usuario.
 */
    @PostMapping
    public Usuario iniciarSesion(@RequestBody Usuario usuario) {

        return usuarioService.iniciarSesion(usuario);

    }

}
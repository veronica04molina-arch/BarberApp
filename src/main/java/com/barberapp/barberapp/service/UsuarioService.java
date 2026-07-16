package com.barberapp.barberapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.barberapp.barberapp.model.Usuario;
import com.barberapp.barberapp.repository.UsuarioRepository;
@Service
public class UsuarioService {

private final UsuarioRepository usuarioRepository;

public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
}
public Usuario guardarUsuario(Usuario usuario) {

    if (usuario.getFechaRegistro() == null) {
        usuario.setFechaRegistro(LocalDate.now());
    }

    return usuarioRepository.save(usuario);
}
public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
}
public Usuario actualizarUsuario(Integer id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }
public void eliminarUsuario(Integer id) {
    usuarioRepository.deleteById(id);
    }
}
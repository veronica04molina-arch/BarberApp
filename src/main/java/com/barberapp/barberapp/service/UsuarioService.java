package com.barberapp.barberapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.barberapp.barberapp.model.Usuario;
import com.barberapp.barberapp.repository.UsuarioRepository;

/**
 * Contiene la lógica de negocio relacionada con los usuarios.
 * Se comunica entre el controlador y el repositorio.
 */
@Service
public class UsuarioService {

private final UsuarioRepository usuarioRepository;

public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
}
/**
 * Guarda un nuevo usuario en la base de datos.
 */
public Usuario guardarUsuario(Usuario usuario) {

    usuario.setFechaRegistro(LocalDate.now());

    System.out.println("Fecha antes de guardar: " + usuario.getFechaRegistro());

    return usuarioRepository.save(usuario);
}
/**
 * Obtiene la lista de todos los usuarios registrados.
 */
public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
/**
 * Busca un usuario por su ID.
 */
public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
}
/**
 * Actualiza la información de un usuario existente.
 */
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
/**
 * Elimina un usuario por su ID.
 */
public void eliminarUsuario(Integer id) {
    usuarioRepository.deleteById(id);
    }
/**
 * Valida las credenciales del usuario para iniciar sesión.
 */
public Usuario iniciarSesion(Usuario usuario) {

    return usuarioRepository.findByEmailAndPassword(
            usuario.getEmail(),
            usuario.getPassword()
    );

}
}
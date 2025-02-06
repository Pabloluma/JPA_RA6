package com.hlc.usuario_uno_a_uno.servicio;


import com.hlc.usuario_uno_a_uno.entidad.enumerado.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.hlc.usuario_uno_a_uno.entidad.Usuario;

public interface UsuarioServicio {
    Usuario guardarOActualizarUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorId(Long id);

    void eliminarUsuario(Long id);

    Page<Usuario> listarUsuariosPaginados(Pageable pageable);

    Page<Usuario> buscarPorNombre(String nombre, Pageable pageable);

    Page<Usuario> buscarRol(Rol rol, Pageable pageable);
}

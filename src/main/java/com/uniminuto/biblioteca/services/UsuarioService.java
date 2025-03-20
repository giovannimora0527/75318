package com.uniminuto.biblioteca.services;

import com.uniminuto.biblioteca.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.apache.coyote.BadRequestException;
/**
 *
 * @author harri
 */
public interface UsuarioService {
    List<Usuario> obtenerListadoUsuarios();

    Optional<Usuario> findUserByEmail(String correo) throws BadRequestException;
}

package com.uniminuto.biblioteca.servicesimpl;

import com.uniminuto.biblioteca.entity.Usuario;
import com.uniminuto.biblioteca.repository.UsuarioRepository;
import com.uniminuto.biblioteca.services.UsuarioService;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio para usuarios.
 * @author lmora
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * Patron para validar email.
     */
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    /**
     * Regex para validacion de email.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Repositorio de usuario.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodo() throws BadRequestException {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorCorreo(String correo) throws BadRequestException {
        Objects.requireNonNull(correo, "El correo es obligatorio");

        if (correo.isBlank() || !validarCorreo(correo)) {
            throw new BadRequestException("El correo proporcionado no es válido.");
        }

        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new BadRequestException("No hay registros de "
                        + "usuarios con el correo ingresado."));
    }

    /**
     * Funcion para validar un correo.
     * @param correo correo a validar.
     * @return si es valido o no.
     */
    private boolean validarCorreo(String correo) {
        return EMAIL_PATTERN.matcher(correo).matches();
    }

}

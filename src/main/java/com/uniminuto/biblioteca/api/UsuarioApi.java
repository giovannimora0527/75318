package com.uniminuto.biblioteca.api;

import com.uniminuto.biblioteca.entity.Usuario;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author harri
 */
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public interface UsuarioApi {
        /**
         * Metodo para listar los usuario registrados en base de datos.
         *
         * @return Lista de usuario.
         * @throws BadRequestException excepcion.
         */
        @RequestMapping(value = "/listar", produces = { "application/json" }, consumes = {
                        "application/json" }, method = RequestMethod.GET)
        ResponseEntity<List<Usuario>> listarUsuario()
                        throws BadRequestException;

        @RequestMapping(value = "/buscar", produces = { "application/json" }, consumes = {
                        "application/json" }, method = RequestMethod.GET)
        ResponseEntity<Optional<Usuario>> findUserByEmail(
                        @RequestParam String correo)
                        throws BadRequestException;
}

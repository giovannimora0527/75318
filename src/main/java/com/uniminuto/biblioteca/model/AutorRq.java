package com.uniminuto.biblioteca.model;
import lombok.Data;
/**
 *
 * @author harri
 */
@Data
public class AutorRq {
    /**
     * Id autor.
     */
    private Integer idAutor;
    /**
     * Nombre del autor.
     */
    private Integer nombre;
    /**
     * Fecha de nacimiento del autor.
     */
    private String fechaNacimiento;

    /**
     * Nacionalidad del autor.
     */    
    private String nacionalidad;

}
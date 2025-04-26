package com.uniminuto.biblioteca.model;

import lombok.Data;

/**
 *
 * @author harri
 */
@Data
public class LibroRs {
    private String message;
    
public String getMessage(){
    return message;
    }

public void setMessage (String message){
    this.message = message;
}

}
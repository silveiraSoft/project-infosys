package com.infytel.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//, reason = "Entidade no encontrada")
public class EntityNotFoundException extends RuntimeException{
     private static final long serialVersionUID = 1L;
     public EntityNotFoundException(String menssage) {
         super(menssage);
     }
}

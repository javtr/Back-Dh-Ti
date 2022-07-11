package com.example.Integrador.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalException {
    private static Logger logger = Logger.getLogger(GlobalException.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "desde global");
    }
}

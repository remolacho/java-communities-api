package com.communities.app.controllers.enterprises;

import com.communities.app.exceptions.ArgumentErrorException;
import com.communities.app.exceptions.ForbiddenException;
import com.communities.app.exceptions.RecordNotFoundException;
import com.communities.app.exceptions.TenantElementException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("{subdomain}/v1")
public class ApplicationController {
    protected final Log logger = LogFactory.getLog(getClass());

    public static final String PREFIX_ERROR = "error";

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(PREFIX_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(ArgumentErrorException.class)
    public ResponseEntity<?> handlerArgumentErrorException(ArgumentErrorException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(PREFIX_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> handlerForbiddenException(ForbiddenException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of(PREFIX_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(TenantElementException.class)
    public ResponseEntity<?> handlerTenantElementException(TenantElementException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of(PREFIX_ERROR, ex.getMessage()));
    }
}

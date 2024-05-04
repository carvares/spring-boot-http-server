package carvares.webapp.resources.excepitons;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import carvares.webapp.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException obj) {
        System.out.println("Resource not found");
        StandardError error = new StandardError(System.currentTimeMillis(), 404, "Not found", obj.getMessage(),
                "Resource not found.");
        return ResponseEntity.status(404).body(error);
    }
}

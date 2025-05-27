package com.peterpopma.easysix.organizationcommand.exception;

import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OptimisticLockingExceptionHandler {

    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<String> handleOptimisticLockingFailure(OptimisticLockException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Update failed: the resource was modified by another transaction.");
    }
}


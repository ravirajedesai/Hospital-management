package com.hospital_management.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientNotFound.class)
    public ResponseEntity<String> patientNotFound(PatientNotFound ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

    }
}

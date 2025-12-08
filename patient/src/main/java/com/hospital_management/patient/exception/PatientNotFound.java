package com.hospital_management.patient.exception;

public class PatientNotFound extends RuntimeException{
    public PatientNotFound(String message) {
        super(message);
    }
}

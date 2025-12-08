package com.hospital_management.patient.exception;

public class AppointmentNotFound extends RuntimeException{
    public AppointmentNotFound(String message) {
        super(message);
    }
}

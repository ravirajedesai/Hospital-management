package com.microservices.user.service.userservice.Exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{

    public ResourceNotFoundExceptions() {
        super("Resource Not Found On Server..");
    }

    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}

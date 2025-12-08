package com.practice.revision.exception;

import com.practice.revision.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessage employeeNotFoundHandler(EmployeeNotFoundException ex){

        ExceptionMessage message=new ExceptionMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionMessage genericExceptionHandler(Exception ex){

        ExceptionMessage message=new ExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return message;
    }
}

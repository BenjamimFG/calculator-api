package com.benfreitas.calculator_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.benfreitas.calculator_api.exceptions.DivisionByZeroException;
import com.benfreitas.calculator_api.models.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DivisionByZeroException.class)
    @ResponseBody
    public ErrorResponse handleDivisionByZero(final DivisionByZeroException ex) {
        return new ErrorResponse(ex.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ErrorResponse handleNumberFormatException(final NumberFormatException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    //@ExceptionHandler(NoHandlerFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    //@ResponseBody
    //public ErrorResponse handleNoHandlerFound(NoHandlerFoundException e) {
    //    return new ErrorResponse("Not found");
    //}
}

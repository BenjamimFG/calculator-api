package com.benfreitas.calculator_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.benfreitas.calculator_api.exceptions.DivisionByZeroException;
import com.benfreitas.calculator_api.models.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DivisionByZeroException.class)
    @ResponseBody
    public ErrorResponse handleDivisionByZero(final DivisionByZeroException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}
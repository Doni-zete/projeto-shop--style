package br.shop.style.mspayment.handler;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(Integer code, String status, String message) {

    public ExceptionMessage(HttpStatus httpStatus, String message) {
        this(httpStatus.value(), httpStatus.name(), message);
    }
}
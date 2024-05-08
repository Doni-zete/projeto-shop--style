package br.shop.style.mspayment.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionMessage {

    private final Integer code;
    private final String status;
    private final String message;

    public ExceptionMessage(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }
}
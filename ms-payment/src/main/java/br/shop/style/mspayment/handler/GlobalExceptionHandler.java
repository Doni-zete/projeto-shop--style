package br.shop.style.mspayment.handler;

import br.shop.style.mspayment.exception.InstallmentAlreadyExistsException;
import br.shop.style.mspayment.exception.InstallmentNotFoundException;
import br.shop.style.mspayment.exception.PaymentMethodAlreadyExistsException;
import br.shop.style.mspayment.exception.PaymentMethodNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentMethodNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handlePaymentMethodNotFoundException(PaymentMethodNotFoundException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentMethodAlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> handlePaymentMethodAlreadyExistsException(PaymentMethodAlreadyExistsException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InstallmentNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleInstallmentNotFoundException(InstallmentNotFoundException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ExceptionMessage> handleNoResourceFoundException(NoResourceFoundException e) {
        var response = new ExceptionMessage(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionMessage> handleValidationException(ValidationException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionMessage> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InstallmentAlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> handleInstallmentAlreadyExistsException(InstallmentAlreadyExistsException e) {
        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionMessage> handleConstraintViolationException(ConstraintViolationException e) {
        String violations = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));

        var response = new ExceptionMessage(HttpStatus.BAD_REQUEST, violations);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

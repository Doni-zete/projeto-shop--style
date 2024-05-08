package br.shop.style.mspayment.exception;

public class PaymentMethodAlreadyExistsException extends RuntimeException {
    public PaymentMethodAlreadyExistsException(String message) {
        super(message);
    }
}

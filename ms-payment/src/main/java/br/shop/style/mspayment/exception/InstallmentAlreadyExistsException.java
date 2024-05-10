package br.shop.style.mspayment.exception;

public class InstallmentAlreadyExistsException extends RuntimeException {

    public InstallmentAlreadyExistsException(String message) {
        super(message);
    }
}

package br.shop.style.mspayment.exception;

public class InstallmentNotFoundException extends RuntimeException{
    public InstallmentNotFoundException(String message){
        super(message);
    }
}
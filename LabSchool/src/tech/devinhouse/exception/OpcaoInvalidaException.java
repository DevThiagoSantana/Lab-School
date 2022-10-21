package tech.devinhouse.exception;

public class OpcaoInvalidaException extends Exception{


    public OpcaoInvalidaException(String e) {
        super("Opção Invalida" + e);
    }
}

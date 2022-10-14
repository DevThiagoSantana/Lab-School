package tech.devinhouse.Exception;

public class OpcaoInvalidaException extends Exception{


    public OpcaoInvalidaException(OpcaoInvalidaException e) {
        super("Opção Invalida" + e);
    }
}

package tech.devinhouse.Exception;

public class OpcaoInvalidaException extends Exception{


    public OpcaoInvalidaException(String e) {
        super("Opção Invalida" + e);
    }
}

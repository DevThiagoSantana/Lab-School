package tech.devinhouse;

import tech.devinhouse.Exception.OpcaoInvalidaException;

public class Main {

    public static void main(String[] args) throws OpcaoInvalidaException {
        Aplicacao aplicacao = new Aplicacao();
        try {
            aplicacao.executar();
        } catch (OpcaoInvalidaException e) {
            throw new OpcaoInvalidaException(e);
        }
    }
}
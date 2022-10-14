package tech.devinhouse.model;

public enum PreOperacao {

    Sair,
    Cadastro,
    Atendimento,
    Relatorio;

    public static PreOperacao obterCodigoPreMenu(int codigo) {
        PreOperacao[] preOperacaos = PreOperacao.values();
        return preOperacaos[codigo];
    }

}

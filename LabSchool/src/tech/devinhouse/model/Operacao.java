package tech.devinhouse.model;

public enum Operacao {
    Sair,
    Cadastro_de_Aluno,
    Atualizacao_da_Situacao_da_matricula_de_Aluno,
    Cadastro_de_Professor,
    Cadastro_de_Pedagogo,
    Realizacao_de_Atendimento_Pedagogico,
    Listagem_de_Pessoas,
    Relatorio_dos_Alunos,
    Relatorio_dos_Professores,
    Relatorio_e_Alunos_com_mais_atendimentos_pedagógicos,
    Pedagogos_com_mais_atendimentos_pedagogicos;

    public static Operacao obterCodigoMenu(int codigo) {
        Operacao[] operacaos = Operacao.values();
        return operacaos[codigo];
    }
}

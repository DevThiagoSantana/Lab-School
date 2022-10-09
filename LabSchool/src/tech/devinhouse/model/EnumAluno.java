package tech.devinhouse.model;

public enum EnumAluno {
    Ativo,
    Irregular,
    Atendimento_Pedagógico,
    Inativo;


    public static EnumAluno obterOpcaoAluno(int codigoAluno) {
        EnumAluno[] situacaoAluno = EnumAluno.values();
        return situacaoAluno[codigoAluno - 1];
    }
}

package tech.devinhouse.model;

public enum EnumListaPessoa  {
    Alunos,
    Professores,
    Pedagogos,
    Todos;
    public static EnumListaPessoa obterOpcaoLista(int codigoLista) {
        EnumListaPessoa[] tipoPessoa = EnumListaPessoa.values();
        return tipoPessoa[codigoLista - 1];

    }
}

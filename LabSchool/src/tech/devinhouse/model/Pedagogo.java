package tech.devinhouse.model;

public class Pedagogo extends Pessoa{
    long AtendimentoPedagogo;

    public Pedagogo(String nome, String telefone, String dataDeNascimento, Long cpf, long atendimentoPedagogo) {
        super(nome, telefone, dataDeNascimento, cpf);
        AtendimentoPedagogo = atendimentoPedagogo;
    }

    @Override
    public String toString() {
        return "Pedagogo{" +
                "AtendimentoPedagogo=" + AtendimentoPedagogo +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", cpf=" + cpf +
                ", codigoId=" + codigoId +
                '}';
    }

    public long getAtendimentoPedagogo() {
        return AtendimentoPedagogo;
    }

    public void setAtendimentoPedagogo(long atendimentoPedagogo) {
        AtendimentoPedagogo = atendimentoPedagogo;
    }
}

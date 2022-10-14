package tech.devinhouse.model;

import java.time.LocalDate;

public class Pedagogo extends Pessoa implements Comparable<Pedagogo>{
    int AtendimentoPedagogo;

    public Pedagogo(String nome, String telefone, LocalDate dataDeNascimento, String cpf, int atendimentoPedagogo) {
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
    public String exibirRelatorio(){
        return "ID: "+codigoId+ " Nome: "+nome+" Cpf:"+cpf+".";
    }
    public String exibirAtendimento(){
        return "ID: "+codigoId+
                " Nome: "+nome+
                " Total de Atendimentos:"+AtendimentoPedagogo+
                ".";
    }

    public int getAtendimentoPedagogo() {
        return AtendimentoPedagogo;
    }

    public void setAtendimentoPedagogo(int atendimentoPedagogo) {
        AtendimentoPedagogo = atendimentoPedagogo;
    }

    @Override
    public int compareTo(Pedagogo o) {
        return (this.AtendimentoPedagogo -o.getAtendimentoPedagogo());
    }
}

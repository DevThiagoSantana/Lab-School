package tech.devinhouse.model;

import java.time.LocalDate;

public class Pedagogo extends Pessoa implements Comparable<Pedagogo>{
    private int AtendimentoPedagogo;

    public Pedagogo(String nome, String telefone, LocalDate dataDeNascimento, String cpf, int atendimentoPedagogo) {
        super(nome, telefone, dataDeNascimento, cpf);
        AtendimentoPedagogo = atendimentoPedagogo;
    }

    @Override
    public String toString() {
        return "Pedagogo{" +
                "AtendimentoPedagogo=" + AtendimentoPedagogo +
                ", nome='" + getNome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", dataDeNascimento='" + getDataDeNascimento() + '\'' +
                ", cpf=" + getCpf() +
                ", codigoId=" + getCodigoId() +
                '}';
    }
    public String exibirRelatorio(){
        return "ID: "+getCodigoId()+ " Nome: "+ getNome() +" Cpf:"+getCpf()+".";
    }
    public String exibirAtendimento(){
        return "ID: "+getCodigoId()+
                " Nome: "+ getNome() +
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

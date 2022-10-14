package tech.devinhouse.model;

import java.time.LocalDate;

public abstract class Pessoa {
    String nome;
    String telefone;
    LocalDate dataDeNascimento;
    String cpf;
    long codigoId;

    public Pessoa( String nome, String telefone, LocalDate dataDeNascimento, String cpf ) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", cpf=" + cpf +
                ", codigoId=" + codigoId +
                '}';
    }
    public String exibirrelatorio(){
        return "Id: "+codigoId+ " Nome: "+nome+" Cpf:"+cpf+".";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(long codigoId) {
        this.codigoId = codigoId;
    }
}

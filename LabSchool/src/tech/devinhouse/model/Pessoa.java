package tech.devinhouse.model;

public abstract class Pessoa {
    String nome;
    String telefone;
    String dataDeNascimento;
    Long cpf;
    long codigoId;

    public Pessoa( String nome, String telefone, String dataDeNascimento, Long cpf ) {
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

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public long getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(long codigoId) {
        this.codigoId = codigoId;
    }
}

package tech.devinhouse.model;

public class Aluno extends Pessoa{
    String situacaoAluno;
    double notaProcesso;
    long atendimentoPedagogico;

    public Aluno(String nome, String telefone, String dataDeNascimento, Long cpf, String situacaoAluno, double notaProcesso, long atendimentoPedagogico) {
        super(nome, telefone, dataDeNascimento, cpf);
        this.situacaoAluno = situacaoAluno;
        this.notaProcesso = notaProcesso;
        this.atendimentoPedagogico = atendimentoPedagogico;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "situacaoAluno='" + situacaoAluno + '\'' +
                ", notaProcesso=" + notaProcesso +
                ", atendimentoPedagogico=" + atendimentoPedagogico +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", cpf=" + cpf +
                ", codigoId=" + codigoId +
                '}';
    }

    public String getSituacaoAluno() {
        return situacaoAluno;
    }

    public void setSituacaoAluno(String situacaoAluno) {
        this.situacaoAluno = situacaoAluno;
    }

    public double getNotaProcesso() {
        return notaProcesso;
    }

    public void setNotaProcesso(double notaProcesso) {
        this.notaProcesso = notaProcesso;
    }

    public long getAtendimentoPedagogico() {
        return atendimentoPedagogico;
    }

    public void setAtendimentoPedagogico(long atendimentoPedagogico) {
        this.atendimentoPedagogico = atendimentoPedagogico;
    }
}

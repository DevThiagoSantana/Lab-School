package tech.devinhouse.model;

import java.time.LocalDate;

public class Aluno extends Pessoa implements Comparable<Aluno>{
    String situacaoAluno;
    double notaProcesso;
    int atendimentoPedagogico;

    public Aluno(String nome, String telefone, LocalDate dataDeNascimento, String cpf, String situacaoAluno, double notaProcesso, int atendimentoPedagogico) {
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
    public String exibirRelatorio(){
        return "Id: "+codigoId+ " Nome: "+nome+" Cpf:"+cpf+".";
    }
    public String exibirRelatorioAluno(){
        return " Id: "+codigoId+
                " Nome: "+nome+" " +
                " Nota:"+notaProcesso+
                " Atendimentos pedagogicos: "
                +atendimentoPedagogico+".";
    }
    public String exibirAtendimento(){
        return "ID: "+codigoId+" Nome: "+nome+" Total de Atendimentos:"+atendimentoPedagogico+".";
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

    public int getAtendimentoPedagogico() {
        return atendimentoPedagogico;
    }

    public void setAtendimentoPedagogico(int atendimentoPedagogico) {
        this.atendimentoPedagogico = atendimentoPedagogico;
    }

    @Override
    public int compareTo(Aluno o) {

        return  (this.atendimentoPedagogico - o.getAtendimentoPedagogico());
    }
}

package tech.devinhouse.model;

import java.time.LocalDate;

public class Aluno extends Pessoa implements Comparable<Aluno>{
    private String situacaoAluno;
    private double notaProcesso;
    private int atendimentoPedagogico;

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
                ", nome='" + getNome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", dataDeNascimento='" + getDataDeNascimento() + '\'' +
                ", cpf=" + getCpf() +
                ", codigoId=" + getCodigoId() +
                '}';
    }
    public String exibirRelatorio(){
        return "Id: "+getCodigoId()+ " Nome: "+getNome()+" Cpf:"+getCpf()+".";
    }
    public String exibirRelatorioAluno(){
        return " Id: "+getCodigoId()+
                " Nome: "+getNome()+" " +
                " Nota:"+notaProcesso+
                " Atendimentos pedagogicos: "
                +atendimentoPedagogico+".";
    }
    public String exibirAtendimento(){
        return "ID: "+getCodigoId()+" Nome: "+getNome()+" Total de Atendimentos:"+atendimentoPedagogico+".";
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

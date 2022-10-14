package tech.devinhouse.model;

import java.time.LocalDate;

public class Professor extends Pessoa{
    String graduacao;
    String experiencia;
    String statusProfessor;

    public Professor(String nome, String telefone, LocalDate dataDeNascimento, String cpf, String graduacao, String experiencia, String statusProfessor) {
        super(nome, telefone, dataDeNascimento, cpf);
        this.graduacao = graduacao;
        this.experiencia = experiencia;
        this.statusProfessor = statusProfessor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "graduacao='" + graduacao + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", statusProfessor='" + statusProfessor + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", cpf=" + cpf +
                ", codigoId=" + codigoId +
                '}';
    }
    public String exibirRelatorio(){
        return " Id: "+codigoId+
                " Nome: "+nome+
                " Cpf:"+cpf+
                ".";
    }
    public String exibirRelatorioProfessor(){
        return "Id: "+codigoId+
                " Nome: "+nome+
                " Formação Academica: "+graduacao+
                " Experiencia: "+experiencia+
                " Status: "+statusProfessor+".";
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(String statusProfessor) {
        this.statusProfessor = statusProfessor;
    }
}

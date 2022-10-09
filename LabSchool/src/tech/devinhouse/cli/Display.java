package tech.devinhouse.cli;

import tech.devinhouse.model.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Display {
    int idMaster = 0;
    EnumAluno situacao=null;
    long id = 0;

    public void exibirMenu(){
        System.out.println("");
        System.out.println("------------MENU------------");
        System.out.println("");
        System.out.println("1  - Cadastro de Aluno");
        System.out.println("2  - Atualização da Situação da matrícula de Aluno");
        System.out.println("3  - Cadastro de Professor");
        System.out.println("4  - Cadastro de Pedagogo");
        System.out.println("5  - Realização de Atendimento Pedagógico");
        System.out.println("6  - Listagem de Pessoas");
        System.out.println("7  - Relatório dos Alunos");
        System.out.println("8  - Relatório dos Professores");
        System.out.println("9  - Relatório de Alunos com mais atendimentos pedagógicos");
        System.out.println("10 - Pedagogos com mais atendimentos pedagógicos");
        System.out.println("0  - Sair");
    }// Menu Inicial do Programa


    public Operacao obterOperacao() {
        int menu = 1;
        Operacao operacao = null;
        while (menu == 1) {
            System.out.print("Digite a Opçao Desejada: ");
            Scanner scanner = new Scanner(System.in);
            int codigoMenu = scanner.nextInt();
            operacao = Operacao.obterCodigoMenu(codigoMenu);
            System.out.println("Voce Escolheu a Opção " + operacao);
            System.out.println("Digite Sim [S]  ou Não[N]");
            String confirmaOpcao = scanner.next();
            confirmaOpcao = confirmaOpcao.toUpperCase();
            if (confirmaOpcao.equals("S")) {
                return operacao;
            } else if (confirmaOpcao !="N") {
                System.out.println("Opção invalida");
            }

        }
        return operacao;


    }

    public void exibirMensagem(String msg) {

        System.out.println(msg);
    }

    public Pessoa cadastrar(TipoPessoa tipo) {
        if (tipo == TipoPessoa.Aluno) {
            System.out.println("Bem Vindo ao Cadastro de Aluno");
        }
        if (tipo == TipoPessoa.Professor) {
            System.out.println("Bem Vindo Ao Cadastro de Professores");
        }
        if (tipo == TipoPessoa.Pedagogo) {
            System.out.println("Bem Vindo Ao Cadastro de Pedagogos");
        }
        System.out.printf("Favor Digitar o Nome do aluno :");
        Scanner scanner = new Scanner(System.in);
        String nomeAluno = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite o numero do telefone do aluno:[(dd)xxxxx-xxxx]");
        String telefoneAluno = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite a Data de nascimento do Aluno:(dd/MM/yyyy) ");
        String nascimentoAluno = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite o Número do CPF do Aluno:(xxx.xxx.xxx-xx)");
        Long cpf = scanner.nextLong();
        System.out.println("");

        Pessoa pessoas = null;
        if (tipo == TipoPessoa.Aluno) {
            System.out.printf("Qual a Nota do Processo Seletivo do Aluno: (de 1 a 10)");
            int notaProcessoSeletivo = scanner.nextInt();
            String situacao = String.valueOf(obterStatusAluno());
            int atendimentoPedagogico = 0;
            pessoas = new Aluno( nomeAluno, telefoneAluno, nascimentoAluno, cpf, situacao, notaProcessoSeletivo, atendimentoPedagogico);
        } else if (tipo == TipoPessoa.Professor) {
            String graduacao =String.valueOf(obterGraduacaoProfessor());
            String experiencia =String.valueOf(obterExperienciaProfessor());
            String status = String.valueOf(obterStatusProfessor());
        }else if (tipo == TipoPessoa.Pedagogo){


        }


        return pessoas;
    }

    public EnumAluno obterStatusAluno (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a Situação da Matricula do Aluno:");
        System.out.println("");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativo");
        System.out.println(" Digite a Opção Desejada :");
        EnumAluno situacao = EnumAluno.obterOpcaoAluno(scanner.nextInt());
        return situacao;
    }

    public EnumProfessor obterGraduacaoProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a Formação Academica do Professor");
        System.out.println("");
        System.out.println("1 - Graduação incompleta ");
        System.out.println("2 - Graduação completa ");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado" );
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor graduacao = EnumProfessor.obterGraduacaoProfessor(scanner.nextInt());
        return graduacao;
    }

    public EnumProfessor obterExperienciaProfessor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a Experiencia do Professor ");
        System.out.println("");
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full-Stack");
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor experiencia = EnumProfessor.obterExperienciaPreofessor(scanner.nextInt());
        return experiencia;
    }
    public EnumProfessor obterStatusProfessor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o Status do Professor ");
        System.out.println("");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor status = EnumProfessor.obterExperienciaPreofessor(scanner.nextInt());
        return status;
    }

    public void listar(List<Pessoa> pessoas) {
        for(Pessoa pessoa :pessoas ) {
            System.out.println(pessoa);
        }
    }

}




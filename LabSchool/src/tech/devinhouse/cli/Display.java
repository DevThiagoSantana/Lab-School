package tech.devinhouse.cli;

import tech.devinhouse.model.*;

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
                aguardar();
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
        System.out.printf("Favor Digitar o Nome :");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite o numero do telefone :[(dd)xxxxx-xxxx]");
        String telefone = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite a Data de nascimento :(dd/MM/yyyy) ");
        String nascimento = scanner.nextLine();
        System.out.println("");
        System.out.printf("Digite o Número do CPF :(xxx.xxx.xxx-xx)");
        Long cpf = scanner.nextLong();
        System.out.println("");

        Pessoa pessoas = null;
        if (tipo == TipoPessoa.Aluno) {
            System.out.printf("Qual a Nota do Processo Seletivo do Aluno: (de 1 a 10)");
            double notaProcessoSeletivo = scanner.nextDouble();
            String situacao = obterStatusAluno().name();
            int atendimentoPedagogico = 0;
            pessoas = new Aluno( nome, telefone, nascimento, cpf, situacao, notaProcessoSeletivo, atendimentoPedagogico);
            System.out.println("Cadastro do Aluno Conclúido");
            aguardar();
        } else if (tipo == TipoPessoa.Professor) {
            String graduacao =obterGraduacaoProfessor().name();
            String experiencia =obterExperienciaProfessor().name();
            String status = obterStatusProfessor().name();
            pessoas= new Professor(nome,telefone,nascimento,cpf,graduacao,experiencia,status);
            System.out.println("Cadastro do Professor Concluido");
            aguardar();
        }else if (tipo == TipoPessoa.Pedagogo){
            int atendimentoPedagogico =0;
            pessoas = new Pedagogo(nome,telefone,nascimento,cpf,atendimentoPedagogico);
            System.out.println("Cadastro do Pedagogo Conclúido");
            aguardar();
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
    public EnumListaPessoa obterTipoPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o Tipo de Lista :");
        System.out.println("");
        System.out.println("1 - Alunos");
        System.out.println("2 - Professores");
        System.out.println("3 - Pedagogos");
        System.out.println("4 - Todos");
        System.out.println(" Digite a Opção Desejada :");
        EnumListaPessoa tipoLista = EnumListaPessoa.obterOpcaoLista(scanner.nextInt());
        return tipoLista;

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

    public int obterId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o id de Matricula ");
        int id = scanner.nextInt();
        return id;

    }


    public void listarAluno(List<Pessoa> pessoas) {
        for(Pessoa pessoa :pessoas ) {
            Aluno aluno = (Aluno) pessoa;
            if (pessoa instanceof Aluno)
            System.out.println(pessoa);
        }
        System.out.println();
    }

    public void listarProfessor(List<Pessoa> pessoas) {
        for(Pessoa pessoa :pessoas ) {
            if (pessoa instanceof Professor)
                System.out.println(pessoa);
        }
        System.out.println();
    }
    public void listarPedagogo(List<Pessoa> pessoas) {
        for(Pessoa pessoa :pessoas ) {
            if (pessoa instanceof Pedagogo)
                System.out.println(pessoa);
        }
        System.out.println();
    }

    public void aguardar() {
        System.out.println("Pressione Qualquer Tecla para Continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }
}




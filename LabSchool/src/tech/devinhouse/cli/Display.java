package tech.devinhouse.cli;

import tech.devinhouse.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    int idMaster = 0;
    EnumAluno situacao = null;
    long id = 0;

    public void intro(){
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("                                          bbbbbbbb                                                                                                                      ");
        System.out.println("LLLLLLLLLLL                               b::::::b                    SSSSSSSSSSSSSSS                     hhhhhhh                                               lllllll ");
        System.out.println("L:::::::::L                               b::::::b                  SS:::::::::::::::S                    h:::::h                                               l:::::l ");
        System.out.println("L:::::::::L                               b::::::b                 S:::::SSSSSS::::::S                    h:::::h                                               l:::::l ");
        System.out.println("LL:::::::LL                                b:::::b                 S:::::S     SSSSSSS                    h:::::h                                               l:::::l ");
        System.out.println("  L:::::L                 aaaaaaaaaaaaa    b:::::bbbbbbbbb         S:::::S                cccccccccccccccc h::::h hhhhh          ooooooooooo      ooooooooooo    l::::l ");
        System.out.println("  L:::::L                 a::::::::::::a   b::::::::::::::bb       S:::::S              cc:::::::::::::::c h::::hh:::::hhh     oo:::::::::::oo  oo:::::::::::oo  l::::l ");
        System.out.println("  L:::::L                 aaaaaaaaa:::::a  b::::::::::::::::b       S::::SSSS          c:::::::::::::::::c h::::::::::::::hh  o:::::::::::::::oo:::::::::::::::o l::::l ");
        System.out.println("  L:::::L                          a::::a  b:::::bbbbb:::::::b       SS::::::SSSSS    c:::::::cccccc:::::c h:::::::hhh::::::h o:::::ooooo:::::oo:::::ooooo:::::o l::::l ");
        System.out.println("  L:::::L                   aaaaaaa:::::a  b:::::b    b::::::b         SSS::::::::SS  c::::::c     ccccccc h::::::h   h::::::ho::::o     o::::oo::::o     o::::o l::::l ");
        System.out.println("  L:::::L                 aa::::::::::::a  b:::::b     b:::::b            SSSSSS::::S c:::::c              h:::::h     h:::::ho::::o     o::::oo::::o     o::::o l::::l ");
        System.out.println("  L:::::L                a::::aaaa::::::a  b:::::b     b:::::b                 S:::::Sc:::::c              h:::::h     h:::::ho::::o     o::::oo::::o     o::::o l::::l ");
        System.out.println("  L:::::L         LLLLLLa::::a    a:::::a  b:::::b     b:::::b                 S:::::Sc::::::c     ccccccc h:::::h     h:::::ho::::o     o::::oo::::o     o::::o l::::l ");
        System.out.println("LL:::::::LLLLLLLLL:::::La::::a    a:::::a  b:::::bbbbbb::::::b     SSSSSSS     S:::::Sc:::::::cccccc:::::c h:::::h     h:::::ho:::::ooooo:::::oo:::::ooooo:::::ol::::::l");
        System.out.println("L::::::::::::::::::::::La:::::aaaa::::::a  b::::::::::::::::b      S::::::SSSSSS:::::S c:::::::::::::::::c h:::::h     h:::::ho:::::::::::::::oo:::::::::::::::ol::::::l");
        System.out.println("L::::::::::::::::::::::L a::::::::::aa:::a b:::::::::::::::b       S:::::::::::::::SS   cc:::::::::::::::c h:::::h     h:::::h oo:::::::::::oo  oo:::::::::::oo l::::::l");
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLL  aaaaaaaaaa  aaaa bbbbbbbbbbbbbbbb         SSSSSSSSSSSSSSS       cccccccccccccccc hhhhhhh     hhhhhhh   ooooooooooo      ooooooooooo   llllllll");
        System.out.println(ConsoleColors.RESET);
        System.out.println();




    }

    public void exibirMenu() {
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
        System.out.println();
    }// Menu Inicial do Programa


    public Operacao obterOperacao() {
        int menu = 1;
        Operacao operacao = null;
        while (menu == 1) {
            System.out.print("Digite a Opçao Desejada: ");
            Scanner scanner = new Scanner(System.in);
            int codigoMenu = scanner.nextInt();
            operacao = Operacao.obterCodigoMenu(codigoMenu);
            System.out.println(ConsoleColors.GREEN);
            System.out.println("Voce Escolheu a Opção " + operacao);
            System.out.println("Digite Sim [S]  ou Não[N]");
            System.out.println(ConsoleColors.RESET);
            String confirmaOpcao = scanner.next();
            confirmaOpcao = confirmaOpcao.toUpperCase();
            if (confirmaOpcao.equals("S")) {
                return operacao;
            } else if (!confirmaOpcao.equals( "N")) {
                System.out.println("Opção invalida");
                aguardar();
            }
            exibirMenu();

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
        String cpf = scanner.next();
        System.out.println("");
        Pessoa pessoas = null;
        if (tipo == TipoPessoa.Aluno) {
            System.out.printf("Qual a Nota do Processo Seletivo do Aluno: (de 1 a 10)");
            double notaProcessoSeletivo = scanner.nextDouble();
            String situacao = obterStatusAluno().name();
            if (!situacao.equals(EnumAluno.Todos.name())) {
                int atendimentoPedagogico = 0;
                pessoas = new Aluno(nome, telefone, nascimento, cpf, situacao, notaProcessoSeletivo, atendimentoPedagogico);
                System.out.println("Cadastro do Aluno Conclúido");
                aguardar();
            }else {
                exibirMensagem("Opçao Invalida");
                aguardar();
            }
        } else if (tipo == TipoPessoa.Professor) {
            String graduacao = obterGraduacaoProfessor().name();
            String experiencia = obterExperienciaProfessor().name();
            if(!experiencia.equals( EnumAluno.Todos.name())){
                String status = obterStatusProfessor().name();
                pessoas = new Professor(nome, telefone, nascimento, cpf, graduacao, experiencia, status);
                System.out.println("Cadastro do Professor Concluido");
                aguardar();
            }else{
                exibirMensagem("Opçao Invalida");
                aguardar();
            }
        } else if (tipo == TipoPessoa.Pedagogo) {
            int atendimentoPedagogico = 0;
            pessoas = new Pedagogo(nome, telefone, nascimento, cpf, atendimentoPedagogico);
            System.out.println("Cadastro do Pedagogo Conclúido");
            aguardar();
        }
        return pessoas;
    }

    public EnumAluno obterStatusAluno() {
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
    public EnumAluno obterStatusAluno2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a Situação da Matricula do Aluno:");
        System.out.println("");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativo");
        System.out.println("5 - Todos");
        System.out.println(" Digite a Opção Desejada :");
        EnumAluno situacao = EnumAluno.obterOpcaoAluno(scanner.nextInt());
        return situacao;

    }



    public EnumListaPessoa obterTipoPessoa() {
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
        System.out.println("4 - Doutorado");
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor graduacao = EnumProfessor.obterGraduacaoProfessor(scanner.nextInt());
        return graduacao;
    }

    public EnumProfessor obterExperienciaProfessor() {
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
    public EnumProfessor obterExperienciaProfessor2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a Experiencia do Professor ");
        System.out.println("");
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full-Stack");
        System.out.println("4 - Todos ");
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor experiencia = EnumProfessor.obterExperienciaPreofessor(scanner.nextInt());
        return experiencia;
    }

    public EnumProfessor obterStatusProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o Status do Professor ");
        System.out.println("");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
        System.out.println(" Digite a Opção Desejada :");
        EnumProfessor status = EnumProfessor.obterExperienciaPreofessor(scanner.nextInt());
        return status;
    }

    public int obterId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o id em Questão? ");
        int id = scanner.nextInt();
        return id;

    }


    public void listarAluno(List<Pessoa> pessoas) {
        System.out.println("Lista de Alunos:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println(aluno.exibirRelatorio());
            }
        }
        System.out.println();
    }
    public void listarAlunoAtendimento(List<Aluno> pessoas) {
        System.out.println("Lista de Alunos:");
        for (Aluno pessoa : pessoas) {
                System.out.println(pessoa.exibirAtendimento());
        }
        System.out.println();
    }

    public void listarProfessor(List<Pessoa> pessoas) {
        System.out.println("Lista de Professores: ");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                Professor professor = (Professor)pessoa;
                System.out.println(professor.exibirRelatorio());
            }
        }
        System.out.println();
    }

    public void listarPedagogo(List<Pessoa> pessoas) {
        System.out.println("Lista de Pedagogo:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Pedagogo){
                Pedagogo pedagogo = (Pedagogo)pessoa;
                System.out.println(pedagogo.exibirRelatorio());
            }

        }
        System.out.println();
    }
    public void listarPedagogoAtendimento(List<Pedagogo> pessoas) {
        System.out.println("Lista de Pedagogo por Atendimento:");
        for (Pedagogo pessoa : pessoas) {
            System.out.println(pessoa.exibirAtendimento());
        }
        System.out.println();
    }

    public void aguardar() {
        System.out.println("Pressione Qualquer Tecla para Continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }
    public void aguardarSair() {
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT);
        System.out.println("Pressione Qualquer Tecla para SAIR... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }


    public void listarAlunoStatus(List<Pessoa> pessoas ,EnumAluno status) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                if (status.name().equals(EnumAluno.Todos.name())){
                    System.out.println(aluno.exibirRelatorioAluno());
                }
                if (aluno.getSituacaoAluno().equals(status.name())) {
                    System.out.println(aluno.exibirRelatorioAluno());
                }
            }
        }
        System.out.println();
    }
    public void listarProfessorStatus(List<Pessoa> pessoas ,EnumProfessor status){
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                Professor professor = (Professor) pessoa;
                if (status.name().equals(EnumProfessor.Todos.name())){
                    System.out.println(professor.exibirRelatorioProfessor());
                }
                if (professor.getExperiencia().equals(status.name())) {
                    System.out.println(professor.exibirRelatorioProfessor());
                }
            }
        }
        System.out.println();

    }



}




package tech.devinhouse;

import tech.devinhouse.exception.OpcaoInvalidaException;
import tech.devinhouse.util.ConsoleColors;
import tech.devinhouse.cli.Display;
import tech.devinhouse.model.*;
import tech.devinhouse.repository.PessoasRepository;

import java.util.List;
import java.util.Scanner;

public class Aplicacao {

   public Display display = new Display();
   private PessoasRepository repo = new PessoasRepository();

    public void executar()  {

        Operacao operacao = null;
        PreOperacao preOperacao =null ;

        display.intro();
        display.aguardar();


        while (operacao != Operacao.Sair) {

                display.exibirPreMenu();
                preOperacao = display.obterPreOperacao();
                    if (preOperacao != PreOperacao.Sair) {
                        operacao = preProcessar(preOperacao);
                        if (operacao != Operacao.Sair) {
                            processar(operacao);
                        } else {
                            operacao = null;
                        }
                        } else {
                            operacao = Operacao.Sair;
                            processar(operacao);
                    }





        }
    }
    public Operacao preProcessar(PreOperacao preOperacao){
        Scanner scanner = new Scanner(System.in);
        Operacao operacao = null;
        switch (preOperacao){
            case  Cadastro :
                display.exibirMenuCadastro();
                operacao = display.obterOperacaoCadastro();
                return operacao;


            case Atendimento:
                display.exibirMenuAtendimento();
                operacao =display.obterOperacaoAtedimento();
                return operacao;


            case  Relatorio:
                display.exibirMenuRelatorio();
                operacao =display.obterOperacaoRelatorio();
                return operacao;

            case Sair:
                return  operacao = Operacao.Sair;
        }


        return operacao;
    }

public void processar(Operacao operacao){
            Scanner scanner = new Scanner(System.in);
try {
    switch (operacao) {
        case Cadastro_de_Aluno:
                System.out.println("Cadastrando Aluno");
                System.out.println();
                Pessoa aluno = display.cadastrar(TipoPessoa.Aluno);
                repo.inserir(aluno);
                break;

        case Atualizacao_da_Situacao_da_matricula_de_Aluno:
                System.out.println("Atualizando Aluno");
                System.out.println();
                List<Pessoa> listaAluno2 = repo.consultar();
                display.listarAluno(listaAluno2);
                int id = Integer.valueOf(display.obterId());
                String situacao = String.valueOf(display.obterStatusAluno());
                    if (situacao != EnumAluno.Todos.name()) {
                    repo.AtualizaMatriculaAluno(id, situacao);
                 display.aguardar();
                } else {
                    System.out.println("Opção invalida");
                    display.aguardar();
                }
                break;

        case Cadastro_de_Professor:
                System.out.println("Cadastrando Professor");
                System.out.println();
                Pessoa professor = display.cadastrar(TipoPessoa.Professor);
                repo.inserir(professor);
                break;

        case Cadastro_de_Pedagogo:
                System.out.println("Cadastrando Pedagogo");
                System.out.println();
                Pessoa pedagogo = display.cadastrar(TipoPessoa.Pedagogo);
                repo.inserir(pedagogo);
                break;

        case Realizacao_de_Atendimento_Pedagogico:
                System.out.println("Atendimento Pedagogico");
                System.out.println();
                System.out.println("Pedagogos Cadastrados:");
                List<Pessoa> listaPedagogo2 = repo.consultar();
                display.listarPedagogo(listaPedagogo2);
                int idPedagogo = Integer.valueOf(display.obterId());
                repo.atualizarAtendimentoPedagogo(idPedagogo);
                System.out.println("Alunos Cadastrados");
                List<Pessoa> listaAluno3 = repo.consultar();
                display.listarAluno(listaAluno3);
                int idAluno = Integer.valueOf(display.obterId());
                repo.atualizarAtendimentoAluno(idAluno);
                display.aguardar();
                break;

        case Listagem_de_Pessoas:
            System.out.println("Lista Pessoa");
            EnumListaPessoa tipoLista = display.obterTipoPessoa();

            switch (tipoLista) {
                case Alunos:
                    List<Pessoa> listaAluno = repo.consultar();
                    display.listarAluno(listaAluno);
                    display.aguardar();
                    break;

                case Professores:
                    List<Pessoa> listaProfessor = repo.consultar();
                    display.listarProfessor(listaProfessor);
                    display.aguardar();
                    break;

                case Pedagogos:
                    List<Pessoa> listaPedagogo = repo.consultar();
                    display.listarPedagogo(listaPedagogo);
                    display.aguardar();
                    break;

                case Todos:
                    List<Pessoa> todos = repo.consultar();
                    if (todos.isEmpty()) {
                        display.exibirMensagem("Sem Pessoas cadastrados");
                    }
                    display.listarAluno(todos);
                    display.listarProfessor(todos);
                    display.listarPedagogo(todos);
                    display.aguardar();
            }
            break;
        case Relatorio_dos_Alunos:
                System.out.println("Relatorio de Alunos");
                List<Pessoa> pessoasAluno = repo.consultar();
                System.out.println("Escolha o Status dos Alunos que quer Listar");
                String statusAluno = String.valueOf(display.obterStatusAluno2());
                display.listarAlunoStatus(pessoasAluno, EnumAluno.valueOf(statusAluno));
                display.aguardar();
             break;


        case Relatorio_dos_Professores:
                System.out.println("Relatorio dos Professores");
                List<Pessoa> pessoasProfessor = repo.consultar();
                System.out.println("Escolha o Status dos Alunos que quer Listar");
                String statusProfessor = String.valueOf(display.obterExperienciaProfessor2());
                display.listarProfessorStatus(pessoasProfessor, EnumProfessor.valueOf(statusProfessor));
                display.aguardar();
                break;


        case Relatorio_e_Alunos_com_mais_atendimentos_pedagógicos:
                System.out.println("Aluno com Maior Atendimento");
                List<Aluno> alunoOrdem = repo.conusultarAluno();
                display.listarAlunoAtendimento(alunoOrdem);
                alunoOrdem.clear();
                display.aguardar();
            break;

        case Pedagogos_com_mais_atendimentos_pedagogicos:
                System.out.println("Pedagogo com Maior Atendimento");
                List<Pedagogo> pedagogoOrdem = repo.consultaPedagogo();
                display.listarPedagogoAtendimento(pedagogoOrdem);
                pedagogoOrdem.clear();
                display.aguardar();
                break;


        case Sair:
                System.out.println(ConsoleColors.RED_BACKGROUND + "Saindo do programa" + ConsoleColors.RESET);
                display.intro();
                display.aguardarSair();
                break;

    }
}catch (OpcaoInvalidaException e){
    display.exibirMensagem(e.getMessage());
}
}


}

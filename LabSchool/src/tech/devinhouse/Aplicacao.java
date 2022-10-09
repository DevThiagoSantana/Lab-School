package tech.devinhouse;

import tech.devinhouse.cli.Display;
import tech.devinhouse.model.EnumAluno;
import tech.devinhouse.model.Operacao;
import tech.devinhouse.model.Pessoa;
import tech.devinhouse.model.TipoPessoa;
import tech.devinhouse.repository.PessoasRepository;

import java.util.List;
import java.util.Scanner;

public class Aplicacao {

   public Display display = new Display();
   private PessoasRepository repo = new PessoasRepository();

    public void executar() {
        Operacao operacao = null;


        while (operacao != Operacao.Sair) {
            display.exibirMenu();
            operacao = display.obterOperacao();
            processar(operacao);
            System.out.println("Menu Funcional");

        }
    }

public void processar(Operacao operacao){
    Scanner scanner = new Scanner(System.in);
    switch (operacao){
            case Cadastro_de_Aluno:
                System.out.println("Cadastrando Aluno");
                Pessoa aluno = display.cadastrar(TipoPessoa.Aluno);
                repo.inserir(aluno);
                break;
            case Atualizacao_da_Situacao_da_matricula_de_Aluno:
                System.out.println("Atualizando Aluno");


                break;
            case Cadastro_de_Professor:
                System.out.println("Cadastrando Professor");
                Pessoa professor=display.cadastrar(TipoPessoa.Professor);
                repo.inserir(professor);
                break;
            case Cadastro_de_Pedagogo:
                System.out.println("Cadastrando Pedagogo");
                break;
            case Realizacao_de_Atendimento_Pedagogico:
                System.out.println("Atendimento Pedagogico");
                break;
            case Listagem_de_Pessoas:
                System.out.println("Lista Pessoa");
                break;
            case Relatorio_dos_Alunos:
                System.out.println("Relatorio de Alunos");
                List<Pessoa> pessoas = repo.consultar();
                if (pessoas.isEmpty()) {
                    display.exibirMensagem("Sem Alunos cadastrados");
                }
                display.listar(pessoas);
                System.out.println("Pressione qualquer tecla pra continuar...");
                String nada = scanner.next();
                break;
            case Relatorio_dos_Professores:
                System.out.println("Relatorio dos Professores");
                break;
            case Relatorio_e_Alunos_com_mais_atendimentos_pedagógicos:
                System.out.println("Aluno com Maior Atendimento");
                break;
            case Pedagogos_com_mais_atendimentos_pedagogicos:
                System.out.println("Pedagogo com Maior Atendimento");
                break;
            case Sair:
                System.out.println("Saindo do programa");
                break;

        }
}
 public void processarAluno(EnumAluno situacao){

 }

}

package tech.devinhouse.repository;

import tech.devinhouse.model.Aluno;
import tech.devinhouse.model.EnumAluno;
import tech.devinhouse.model.Pedagogo;
import tech.devinhouse.model.Pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PessoasRepository {

        private static int idAtual =0;
        private List<Pessoa> dados = new ArrayList<>();
        private List<Pedagogo>pedagogoOrdem =new ArrayList<>();
        private List<Aluno>alunoOrdem =new ArrayList<>();

        public void inserir(Pessoa pessoas) {
            pessoas.setCodigoId(++idAtual);
            dados.add(pessoas);

        }
        public Aluno AtualizaMatriculaAluno(int id, String situacao){
            for(Pessoa pessoa:dados){
                if (pessoa.getCodigoId() == id){
                    Aluno aluno =(Aluno) pessoa;
                    aluno.setSituacaoAluno(situacao);
                    return aluno;
                }
            }
            return null;
        }


        public Aluno atualizarAtendimentoAluno(int id){
            for (Pessoa pessoa:dados){
                if (pessoa.getCodigoId() == id){
                    Aluno aluno = (Aluno) pessoa;
                    int atendimentoAluno = (int) aluno.getAtendimentoPedagogico();
                    aluno.setAtendimentoPedagogico(++atendimentoAluno);
                    aluno.setSituacaoAluno(EnumAluno.Atendimento_Pedagógico.name());
                    return aluno;
                }
            }
            return null;
        }

        public Pedagogo atualizarAtendimentoPedagogo(int id){
            for(Pessoa pessoa:dados){
                if(pessoa.getCodigoId() == id){
                    Pedagogo pedagogo =(Pedagogo) pessoa;
                    int atendimentoPedagogo = (int) pedagogo.getAtendimentoPedagogo();
                    pedagogo.setAtendimentoPedagogo(++atendimentoPedagogo);
                    return pedagogo;
                }
            }
            return null;
        }

        public List<Pessoa> consultar() {
            return dados;
        }

        public List<Aluno> conusultarAluno() {
            for(Pessoa pessoa:dados){
                if (pessoa instanceof Aluno){
                    Aluno aluno =(Aluno) pessoa;
                    alunoOrdem.add(aluno);
                }

            }
            Collections.sort(alunoOrdem,Collections.reverseOrder());

            return alunoOrdem;
        }

    public List<Pedagogo> consultaPedagogo() {
           for (Pessoa pessoa:dados){
               if(pessoa instanceof Pedagogo){
                   Pedagogo pedagogo =(Pedagogo) pessoa;
                   pedagogoOrdem.add(pedagogo);
               }
           }
           Collections.sort(pedagogoOrdem,Collections.reverseOrder());

        return pedagogoOrdem;
    }
}

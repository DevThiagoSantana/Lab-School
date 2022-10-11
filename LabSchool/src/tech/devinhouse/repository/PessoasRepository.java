package tech.devinhouse.repository;

import tech.devinhouse.model.Aluno;
import tech.devinhouse.model.EnumAluno;
import tech.devinhouse.model.Pedagogo;
import tech.devinhouse.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoasRepository {

        private static int idAtual =0;
        private List<Pessoa> dados = new ArrayList<>();

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
                    long atendimentoAluno = aluno.getAtendimentoPedagogico();
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
                    long atendimentoPedagogo = pedagogo.getAtendimentoPedagogo();
                    pedagogo.setAtendimentoPedagogo(++atendimentoPedagogo);
                    return pedagogo;
                }
            }
            return null;
        }



        public List<Pessoa> consultar() {

            return dados;
        }


}

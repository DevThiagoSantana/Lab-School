package tech.devinhouse.repository;

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

        public List<Pessoa> consultar() {
            return dados;
        }


}

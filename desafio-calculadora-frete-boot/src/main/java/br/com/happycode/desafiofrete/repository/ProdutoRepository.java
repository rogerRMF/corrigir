package br.com.happycode.desafiofrete.repository;

import br.com.happycode.desafiofrete.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
}

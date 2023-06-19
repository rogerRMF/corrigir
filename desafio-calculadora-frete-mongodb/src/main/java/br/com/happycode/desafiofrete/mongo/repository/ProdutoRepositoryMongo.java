package br.com.happycode.desafiofrete.mongo.repository;

import br.com.happycode.desafiofrete.mongo.model.ProdutoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepositoryMongo extends MongoRepository<ProdutoMongo, Long> {
}

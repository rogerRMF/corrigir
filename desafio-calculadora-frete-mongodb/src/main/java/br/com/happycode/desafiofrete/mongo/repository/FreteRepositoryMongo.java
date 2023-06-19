package br.com.happycode.desafiofrete.mongo.repository;

import br.com.happycode.desafiofrete.mongo.model.FreteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreteRepositoryMongo extends MongoRepository<FreteMongo, Long> {
}

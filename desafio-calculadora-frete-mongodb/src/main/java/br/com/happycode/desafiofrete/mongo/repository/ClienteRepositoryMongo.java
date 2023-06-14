package br.com.happycode.desafiofrete.mongo.repository;

import br.com.happycode.desafiofrete.mongo.model.ClienteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClienteRepositoryMongo extends MongoRepository<ClienteMongo, Long> {

}

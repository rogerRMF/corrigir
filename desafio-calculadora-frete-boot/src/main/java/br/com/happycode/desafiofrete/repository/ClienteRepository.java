package br.com.happycode.desafiofrete.repository;

import br.com.happycode.desafiofrete.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

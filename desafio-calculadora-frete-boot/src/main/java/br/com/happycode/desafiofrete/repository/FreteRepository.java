package br.com.happycode.desafiofrete.repository;

import br.com.happycode.desafiofrete.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<Frete, Long> {
}

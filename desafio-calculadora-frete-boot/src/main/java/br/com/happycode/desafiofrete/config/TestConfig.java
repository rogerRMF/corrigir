package br.com.happycode.desafiofrete.config;

import br.com.happycode.desafiofrete.model.Cliente;
import br.com.happycode.desafiofrete.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public void run(String...args) throws Exception {
        Cliente Cliente1 = new Cliente("rogerio", "161.703.660-95", "09581-700","logradouro", "paulista", "jundiaí","sp");
        Cliente Cliente2 = new Cliente("rogerio", "642.596.220-80", "09570-400","logradouro", "paulista", "jundiaí","sp");

        clienteRepository.saveAll(Arrays.asList(Cliente1, Cliente2));
    }

}

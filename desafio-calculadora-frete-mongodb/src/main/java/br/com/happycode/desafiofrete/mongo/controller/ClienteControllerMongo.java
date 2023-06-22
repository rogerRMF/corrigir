package br.com.happycode.desafiofrete.mongo.controller;

import br.com.happycode.desafiofrete.mongo.dto.ClienteDTOMongo;
import br.com.happycode.desafiofrete.mongo.service.ClienteServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/mongo/clientes")
public class ClienteControllerMongo {

    @Autowired
    private final ClienteServiceMongo clienteServiceMongo;

    public ClienteControllerMongo(ClienteServiceMongo clienteServiceMongo) {
        this.clienteServiceMongo = clienteServiceMongo;
    }

    @PostMapping
    public ResponseEntity<ClienteDTOMongo> cadastrarCliente(@RequestBody ClienteDTOMongo clienteDTOMongo) throws IOException, URISyntaxException {
        ClienteDTOMongo clienteCadastrado = clienteServiceMongo.cadastrarCliente(clienteDTOMongo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTOMongo> obterCliente(@PathVariable String id) {
        ClienteDTOMongo clienteDTOMongo = ClienteServiceMongo.obterClienteMongo(id);
        if (clienteDTOMongo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTOMongo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTOMongo> atualizarCliente(@PathVariable String id, @RequestBody ClienteDTOMongo clienteDTOMongo) {
        ClienteDTOMongo clienteAtualizado = clienteServiceMongo.atualizarCliente(id, clienteDTOMongo);
        if (clienteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String id) {
        clienteServiceMongo.deletarCliente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTOMongo>> buscarTodosClientes() {
        List<ClienteDTOMongo> ClienteMongo = ClienteServiceMongo.buscarTodosClientes();
        return ResponseEntity.ok(ClienteMongo);
}
}

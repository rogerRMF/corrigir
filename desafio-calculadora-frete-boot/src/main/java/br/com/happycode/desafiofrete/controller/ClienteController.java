package br.com.happycode.desafiofrete.controller;

import br.com.happycode.desafiofrete.dto.ClienteDTO;
import br.com.happycode.desafiofrete.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Api(value="API REST clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ApiOperation(value="Salva um cliente")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCadastrado = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorno um unico cliente")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.obterCliente(id);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza um cliente")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
        if (clienteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta um produto")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ApiOperation(value="Retorno uma lista de clientes")
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        List<ClienteDTO> clientes = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }
}

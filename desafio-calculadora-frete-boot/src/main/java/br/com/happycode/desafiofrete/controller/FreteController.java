package br.com.happycode.desafiofrete.controller;

import br.com.happycode.desafiofrete.dto.FreteDTO;
import br.com.happycode.desafiofrete.service.FreteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fretes")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<Double> calcularFrete(@RequestBody FreteDTO freteDTO) {
        double valorFrete = freteService.calcularFrete(freteDTO.getTipoCalculo(), freteDTO.getIdProduto(), freteDTO.getIdCliente());
        return ResponseEntity.status(HttpStatus.OK).body(valorFrete);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreteDTO> obterFrete(@PathVariable Long id) {
        FreteDTO freteDTO = freteService.obterFrete(id);
        if (freteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(freteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreteDTO> atualizarFrete(@PathVariable Long id, @RequestBody FreteDTO freteDTO) {
        FreteDTO freteAtualizado = freteService.atualizarFrete(id, freteDTO);
        if (freteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(freteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFrete(@PathVariable Long id) {
        freteService.deletarFrete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FreteDTO>> buscarTodosFretes() {
        List<FreteDTO> fretes = freteService.buscarTodosFretes();
        return ResponseEntity.ok(fretes);
    }
}

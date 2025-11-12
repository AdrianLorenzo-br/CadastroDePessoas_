package dev.Adrian.CadastroDePessoas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    public final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTarefa(@RequestBody TarefasDTO TarefasRequest) {
        TarefasDTO novaTarefa = tarefasService.criarTarefa(TarefasRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa Criada com Sucesso: " + novaTarefa.getNome() + " ID: " + novaTarefa.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefasDTO>> listarTarefas() {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/listar/${id}")
    public ResponseEntity<?> listarTarefaPorID(@PathVariable Long id, @RequestBody TarefasDTO TarefasRequest) {
        TarefasDTO tarefaExistente = tarefasService.listarTarefasPorId(id);
        if (tarefaExistente != null) {
            return ResponseEntity.ok(tarefaExistente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de ID: " + id + " não existe");

    }


    @PutMapping("/alterar/${id}")
    public ResponseEntity<?> alterarTarefaPorId(@PathVariable Long id, @RequestBody TarefasDTO TarefasRequest) {
        TarefasDTO tarefaExistente = tarefasService.listarTarefasPorId(id);
        if (tarefaExistente != null) {
            TarefasDTO tarefaSalva = tarefasService.alterarTarefasPorId(id, TarefasRequest);
            return ResponseEntity.ok(tarefaSalva);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de ID: " + id + " não existe");
    }


    @DeleteMapping("/deletarID")
    public ResponseEntity<String> deletarTarefaPorId(Long id) {
        TarefasDTO tarefaExistente = tarefasService.listarTarefasPorId(id);
        if (tarefaExistente != null) {
            tarefasService.DeletarTarefasPorId(id);
            return ResponseEntity.ok("Tarefa Deletado com Sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa de ID: " + id + " não existe");
    }
}
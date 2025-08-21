package dev.Adrian.CadastroDePessoas.Colaboradores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping(value = "/boasvindas")
    public String boasvindas(){
        return "Essa é a minha primeira mensagem";
    }

    // Adicionar colaboradores (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarColaborador(@RequestBody ColaboradorDTO colaborador){
        ColaboradorDTO novoColaborador = colaboradorService.criarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Colaborador Criado com Sucesso: " + novoColaborador.getNome() + " ID: " + novoColaborador.getId());

    }

    // Mostrar todos os colaboradores (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<ColaboradorDTO>> listarColaboradores(){
        List<ColaboradorDTO> colaboradores = colaboradorService.listarColaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    // Procurar colaborador por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarColaboradoresPorId(@PathVariable Long id) {
        ColaboradorDTO colaborador = colaboradorService.listarColaboradoresPorID(id);
        if(colaborador != null){
            return ResponseEntity.ok(colaborador);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Colaborador de ID: " + id + " não existe");
        }
    }

    // Alterar dados dos colaboradores (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarColaborador(@PathVariable Long id, @RequestBody ColaboradorDTO colaboradorAtualizado){
        ColaboradorDTO colaborador = colaboradorService.atualizarColaborador(id, colaboradorAtualizado);
        if(colaborador != null){
            return ResponseEntity.ok(colaborador);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Colaborador de ID: " + id + " não existe");
        }

    }

    // Deletar Colaboradores (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarColaboradorPorId(@PathVariable Long id){
        if(colaboradorService.listarColaboradoresPorID(id) != null){
            colaboradorService.deletarColaborador(id);
            return ResponseEntity.ok("Colaborador de ID: " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Colaborador de ID: " + id + " não existe");
        }
    }
}
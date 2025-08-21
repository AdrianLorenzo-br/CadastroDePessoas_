package dev.Adrian.CadastroDePessoas.Tarefas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dev/Adrian/CadastroDePessoas/Tarefas")
public class TarefasController {

    // Adicionar (CREATE)
    @PostMapping("/criar")
    public String criarMissao (){
        return "missão criada";
    }

    // Mostrar todos (READ)
    @GetMapping("/listar")
    public String listarTodosAsMissoes (){
        return "Mostrar Missão";
    }

    // Procurar por id (READ)
    @GetMapping("/listarID")
    public String listarMissãoPorID () {
        return "Mostrar Missão por id";
    }

    // Alterar dados(UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissaoPorId (){
        return "Alterar Missão por id";
    }

    // Deletar (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId(){
        return "Missão deletada por id";
    }
}

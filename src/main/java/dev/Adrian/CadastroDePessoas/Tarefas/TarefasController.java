package dev.Adrian.CadastroDePessoas.Tarefas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

    @PostMapping("/criar")
    public String criarTarefa (){
        return "Tarefa criada";
    }


    @GetMapping("/listar")
    public String listarTodasAsTarefas (){
        return "Mostrar Tarefa";
    }


    @GetMapping("/listarID")
    public String listarTarefaPorID () {
        return "Mostrar Tarefa por id";
    }


    @PutMapping("/alterarID")
    public String alterarTarefaPorId (){
        return "Alterar Tarefa por id";
    }

    
    @DeleteMapping("/deletarID")
    public String deletarTarefaPorId(){
        return "Tarefa deletada por id";
    }
}
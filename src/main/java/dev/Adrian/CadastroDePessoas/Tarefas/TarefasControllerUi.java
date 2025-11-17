package dev.Adrian.CadastroDePessoas.Tarefas;

import dev.Adrian.CadastroDePessoas.Colaboradores.ColaboradorDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tarefas/ui")
public class TarefasControllerUi {

    private final TarefasService tarefasService;

    public TarefasControllerUi(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @GetMapping("/listar")
    public String listarTarefas(Model model) {
        List<TarefasDTO> tarefas = tarefasService.listarTarefas();
        model.addAttribute("tarefas", tarefas);
        return "listarTarefas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarColaboradorPorId(@PathVariable Long id) {
        tarefasService.deletarTarefasPorId(id);
        return "redirect:/tarefas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarTarefasPorId(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefasPorId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "detalhesTarefa";
        } else {
            model.addAttribute("mensagem", "Tarefa não encontrada");
            return "listarTarefas";
        }
    }

    @GetMapping("/adicionar")
    public String FormularioAdicionar(Model model) {
        model.addAttribute("tarefa", new TarefasDTO());
        return "adicionarTarefa";
    }

    @PostMapping("/salvar")
    public String salvarTarefa(@ModelAttribute TarefasDTO tarefa, RedirectAttributes redirectAttributes) {
        tarefasService.criarTarefa(tarefa);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa cadastrada com sucesso!");
        return "redirect:/tarefas/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String FormularioAlterar(@PathVariable Long id, Model model) {
        TarefasDTO tarefa = tarefasService.listarTarefasPorId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "alterarTarefa";
        } else {
            model.addAttribute("mensagem", "Tarefa não encontrada!");
            return "redirect:/tarefas/ui/listar";
        }
    }

    @PostMapping("/alterar")
    public String salvarAlteracao(@ModelAttribute TarefasDTO tarefa, RedirectAttributes redirectAttributes) {
        tarefasService.alterarTarefasPorId(tarefa.getId(), tarefa);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa atualizada com sucesso!");
        return "redirect:/tarefas/ui/listar";
    }
}

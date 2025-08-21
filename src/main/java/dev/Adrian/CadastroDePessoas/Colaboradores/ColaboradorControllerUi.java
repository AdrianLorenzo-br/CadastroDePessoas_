package dev.Adrian.CadastroDePessoas.Colaboradores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/colaboradores/ui")
public class ColaboradorControllerUi {

    private final ColaboradorService colaboradorService;

    public ColaboradorControllerUi(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/listar")
    public String listarColaboradores(Model model) {
        List<ColaboradorDTO> colaboradores =  colaboradorService.listarColaboradores();
        model.addAttribute("colaboradores", colaboradores);
        return "listarColaboradores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarColaboradorPorId(@PathVariable Long id) {
        colaboradorService.deletarColaborador(id);
        return "redirect:/colaboradores/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarColaboradoresPorId(@PathVariable Long id, Model model) {
        ColaboradorDTO colaborador =  colaboradorService.listarColaboradoresPorID(id);
        if (colaborador != null) {
            model.addAttribute("colaborador", colaborador);
            return "detalhesColaborador";
        } else {
            model.addAttribute("mensagem", "Colaborador não encontrado");
            return "listarColaboradores";
        }
    }

    @GetMapping("/adicionar")
    public String FormularioAdicionar(Model model) {
        model.addAttribute("colaborador", new ColaboradorDTO());
        return "adicionarColaborador";
    }

    @PostMapping("/salvar")
    public String salvarColaborador(@ModelAttribute ColaboradorDTO colaborador, RedirectAttributes redirectAttributes) {
        colaboradorService.criarColaborador(colaborador);
        redirectAttributes.addFlashAttribute("mensagem", "Colaborador cadastrado com sucesso!");
        return "redirect:/colaboradores/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String FormularioAlterar(@PathVariable Long id, Model model) {
        ColaboradorDTO colaborador = colaboradorService.listarColaboradoresPorID(id);
        if (colaborador != null) {
            model.addAttribute("colaborador", colaborador);
            return "alterarColaborador";
        } else {
            model.addAttribute("mensagem", "Colaborador não encontrado!");
            return "redirect:/colaboradores/ui/listar";
        }
    }

    @PostMapping("/alterar")
    public String salvarAlteracao(@ModelAttribute ColaboradorDTO colaborador, RedirectAttributes redirectAttributes) {
        colaboradorService.atualizarColaborador(colaborador.getId(), colaborador);
        redirectAttributes.addFlashAttribute("mensagem", "Colaborador atualizado com sucesso!");
        return "redirect:/colaboradores/ui/listar";
    }
}
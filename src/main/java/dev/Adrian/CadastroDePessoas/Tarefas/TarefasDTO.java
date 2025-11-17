package dev.Adrian.CadastroDePessoas.Tarefas;

import dev.Adrian.CadastroDePessoas.Colaboradores.ColaboradorModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefasDTO {

    private Long id;
    private String nome;
    private String prioridade;
    private List<ColaboradorModel> colaboradores;

}

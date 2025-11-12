package dev.Adrian.CadastroDePessoas.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Adrian.CadastroDePessoas.Colaboradores.ColaboradorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;
    private String nome;
    private String prioriade;
    private List<ColaboradorModel> colaboradores;

}

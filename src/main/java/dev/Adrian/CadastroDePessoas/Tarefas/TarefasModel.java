package dev.Adrian.CadastroDePessoas.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Adrian.CadastroDePessoas.Colaboradores.ColaboradorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String prioriade;

    @OneToMany(mappedBy = "tarefas")
    @JsonIgnore
    private List<ColaboradorModel> colaboradores;
}
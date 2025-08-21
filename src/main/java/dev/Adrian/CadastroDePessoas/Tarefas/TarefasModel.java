package dev.Adrian.CadastroDePessoas.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Adrian.CadastroDePessoas.Colaboradores.ColaboradorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "tarefas")
    @JsonIgnore
    private List<ColaboradorModel> colaboradores;
}
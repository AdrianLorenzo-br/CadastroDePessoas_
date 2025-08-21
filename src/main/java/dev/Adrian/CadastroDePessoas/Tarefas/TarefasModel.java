package dev.Adrian.CadastroDePessoas.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Adrian.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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

    // @OneToMany - uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "dev/Adrian/CadastroDePessoas/Tarefas")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}

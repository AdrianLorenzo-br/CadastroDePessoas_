package dev.Adrian.CadastroDePessoas.Colaboradores;

import dev.Adrian.CadastroDePessoas.tarefas.TarefasModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String imgUrl;
    private String rank;
    private TarefasModel tarefas;

}}
package dev.Adrian.CadastroDePessoas.Colaboradores;


import dev.Adrian.CadastroDePessoas.Tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// O entity Transforma Uma Classe em Entidade do banco de dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data // cria Getters e Setter
@ToString(exclude = "tarefas")
public class ColaboradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    // diz que o email deve ser unico
    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_Url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne - um colaborador tem varias tarefas
    @ManyToOne
    @JoinColumn(name = "tarefas_id") // foreigner key - chave strangeira
    private TarefasModel tarefas;

}
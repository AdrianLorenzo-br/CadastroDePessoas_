package dev.Adrian.CadastroDePessoas.Tarefas;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TarefasMapper {

    public static TarefasModel toTarefas(TarefasDTO tarefasDTO) {
        return TarefasModel.builder()
                .id(tarefasDTO.getId())
                .nome(tarefasDTO.getNome())
                .prioriade(tarefasDTO.getPrioriade())
                .build();


    }

    public static TarefasDTO toTarefasDTO(TarefasModel tarefasModel) {
        return TarefasDTO.builder()
                .id(tarefasModel.getId())
                .nome(tarefasModel.getNome())
                .prioriade(tarefasModel.getPrioriade())
                .build();


    }
}

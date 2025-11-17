package dev.Adrian.CadastroDePessoas.Tarefas;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@UtilityClass
public class TarefasMapper {

    public static TarefasModel toTarefas(TarefasDTO tarefasDTO) {
        return TarefasModel.builder()
                .id(tarefasDTO.getId())
                .nome(tarefasDTO.getNome())
                .prioridade(tarefasDTO.getPrioridade())
                .build();


    }

    public static TarefasDTO toTarefasDTO(TarefasModel tarefasModel) {
        return TarefasDTO.builder()
                .id(tarefasModel.getId())
                .nome(tarefasModel.getNome())
                .prioridade(tarefasModel.getPrioridade())
                .build();
        
    }
}

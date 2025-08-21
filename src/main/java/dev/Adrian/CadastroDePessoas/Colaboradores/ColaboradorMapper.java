package dev.Adrian.CadastroDePessoas.Colaboradores;

import org.springframework.stereotype.Component;

@Component
public class ColaboradorMapper {

    public ColaboradorModel map(ColaboradorDTO colaboradorDTO) {
        ColaboradorModel colaboradorModel = new ColaboradorModel();
        colaboradorModel.setId(colaboradorDTO.getId());
        colaboradorModel.setNome(colaboradorDTO.getNome());
        colaboradorModel.setEmail(colaboradorDTO.getEmail());
        colaboradorModel.setIdade(colaboradorDTO.getIdade());
        colaboradorModel.setRank(colaboradorDTO.getRank());
        colaboradorModel.setImgUrl(colaboradorDTO.getImgUrl());
        colaboradorModel.setTarefas(colaboradorDTO.getTarefas());

        return colaboradorModel;
    }

    public ColaboradorDTO map(ColaboradorModel colaboradorModel) {

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setId(colaboradorModel.getId());
        colaboradorDTO.setNome(colaboradorModel.getNome());
        colaboradorDTO.setEmail(colaboradorModel.getEmail());
        colaboradorDTO.setIdade(colaboradorModel.getIdade());
        colaboradorDTO.setRank(colaboradorModel.getRank());
        colaboradorDTO.setImgUrl(colaboradorModel.getImgUrl());
        colaboradorDTO.setTarefas(colaboradorModel.getTarefas());

        return colaboradorDTO;
    }

}
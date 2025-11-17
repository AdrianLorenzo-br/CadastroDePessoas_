package dev.Adrian.CadastroDePessoas.Tarefas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    private final TarefasRepository tarefaRepository;


    TarefasService(TarefasRepository tarefasRepository) {
        this.tarefaRepository = tarefasRepository;
    }

    public TarefasDTO criarTarefa(TarefasDTO request) {
        TarefasModel novaTarefa = TarefasMapper.toTarefas(request);
        tarefaRepository.save(novaTarefa);
        return TarefasMapper.toTarefasDTO(novaTarefa);
    }

    public List<TarefasDTO> listarTarefas() {
        List<TarefasModel> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(TarefasMapper::toTarefasDTO)
                .collect(Collectors.toList());
    }

    public TarefasDTO listarTarefasPorId(Long id) {
        Optional<TarefasModel> tarefaPorId = tarefaRepository.findById(id);
        return tarefaPorId.map(TarefasMapper::toTarefasDTO).orElse(null);
    }

    public void deletarTarefasPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefasDTO alterarTarefasPorId(Long id, TarefasDTO request) {
        Optional<TarefasModel> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            TarefasModel tarefaAtualizada = TarefasMapper.toTarefas(request);
            tarefaAtualizada.setId(id);
            tarefaRepository.save(tarefaAtualizada);
            return TarefasMapper.toTarefasDTO(tarefaAtualizada);
        } else {
            return null;
        }
    }

    ;


}

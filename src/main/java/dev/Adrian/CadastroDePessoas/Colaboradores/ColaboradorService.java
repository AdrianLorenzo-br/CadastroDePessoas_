package dev.Adrian.CadastroDePessoas.Colaboradores;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private  final ColaboradorMapper colaboradorMapper;

    public ColaboradorService(ColaboradorRepository colaboradorRepository, ColaboradorMapper colaboradorMapper) {
        this.colaboradorRepository = colaboradorRepository;
        this.colaboradorMapper = colaboradorMapper;
    }

    public List<ColaboradorDTO> listarColaboradores(){
        List<ColaboradorModel> colaboradores = colaboradorRepository.findAll();
        return colaboradores.stream()
                .map(colaboradorMapper::map)
                .collect(Collectors.toList());
    }


    public ColaboradorDTO listarColaboradoresPorID(Long id){
        Optional<ColaboradorModel> colaboradorPorID = colaboradorRepository.findById(id);
        return colaboradorPorID.map(colaboradorMapper::map).orElse(null);
    }


    public ColaboradorDTO criarColaborador(ColaboradorDTO colaboradorDTO){
        ColaboradorModel colaborador = colaboradorMapper.map(colaboradorDTO);
        colaborador = colaboradorRepository.save(colaborador);
        return colaboradorMapper.map(colaborador);
    }


    public void deletarColaborador(Long id){
        colaboradorRepository.deleteById(id);
    }


    public ColaboradorDTO atualizarColaborador(Long id, ColaboradorDTO colaboradorDTO){
        Optional<ColaboradorModel> colaboradorExistente = colaboradorRepository.findById(id);
        if(colaboradorExistente.isPresent()){
            ColaboradorModel colaboradorAtualizado = colaboradorMapper.map(colaboradorDTO);
            colaboradorAtualizado.setId(id);
            ColaboradorModel colaboradorSalvo = colaboradorRepository.save(colaboradorAtualizado);
            return colaboradorMapper.map(colaboradorSalvo);
        }
        return null;
    }

}
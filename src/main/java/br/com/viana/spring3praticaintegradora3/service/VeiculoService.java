package br.com.viana.spring3praticaintegradora3.service;

import br.com.viana.spring3praticaintegradora3.dto.VeiculoDTO;
import br.com.viana.spring3praticaintegradora3.dto.VeiculoRequestDTO;
import br.com.viana.spring3praticaintegradora3.entity.Veiculo;
import br.com.viana.spring3praticaintegradora3.exception.VeiculoNotFoundException;
import br.com.viana.spring3praticaintegradora3.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService implements IVeiculo {

    @Autowired
    private VeiculoRepo repo;

    @Override
    public void addVeiculo(VeiculoRequestDTO veiculo) {
        Veiculo newVeiculo = veiculo.convertToVeiculo();
        this.repo.addVeiculo(newVeiculo);
    }

    @Override
    public List<VeiculoDTO> getVeiculos() {
        List <VeiculoDTO> veiculos = this.repo.getVeiculos()
                .stream()
                .map(v -> new VeiculoDTO(v))
                .collect(Collectors.toList());

        return veiculos;
    }

    @Override
    public Veiculo getVeiculoById(int id) {
        Optional<Veiculo> veiculo = this.repo.getVeiculoById(id);

        if(veiculo.isEmpty()){
            throw new VeiculoNotFoundException("Veiculo com id " + id + " não encontrado");
        }

        return veiculo.get();
    }

    @Override
    public List<VeiculoDTO> getVeiculosByPrice(int since, int to) {
        List <VeiculoDTO> veiculos= this.repo.getVeiculosByPrice(since, to).stream()
                .map(v -> new VeiculoDTO(v)).collect(Collectors.toList());
        return veiculos;
    }
}

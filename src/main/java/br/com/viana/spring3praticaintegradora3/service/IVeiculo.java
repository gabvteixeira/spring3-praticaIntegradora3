package br.com.viana.spring3praticaintegradora3.service;

import br.com.viana.spring3praticaintegradora3.dto.VeiculoDTO;
import br.com.viana.spring3praticaintegradora3.dto.VeiculoRequestDTO;
import br.com.viana.spring3praticaintegradora3.entity.Veiculo;

import java.util.List;

public interface IVeiculo {
    void addVeiculo(VeiculoRequestDTO veiculo);
    List<VeiculoDTO> getVeiculos();
    Veiculo getVeiculoById(int id);

    List<VeiculoDTO> getVeiculosByPrice(int since, int to);
}

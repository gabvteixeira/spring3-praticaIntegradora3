package br.com.viana.spring3praticaintegradora3.repository;

import br.com.viana.spring3praticaintegradora3.entity.Services;
import br.com.viana.spring3praticaintegradora3.entity.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VeiculoRepo {
    private List<Veiculo> veiculos = new ArrayList<>(){
        {
            add(
                    new Veiculo(1, "Chevrolet", "Beta", "AR",
                            "2000-02-01",1000,5,1000,
                    new ArrayList<Services>(){
                    {
                        add(new Services(new Date(2001,Calendar.NOVEMBER,2), 100, "Servico1"));}
                    }
                        )
            );

            add(
                new Veiculo(2, "Honda", "Alfa", "BR",
                        "2004-11-10",1200,5,800,
                        new ArrayList<Services>(){
                            {
                                add(new Services(new Date(2020,Calendar.NOVEMBER,2), 100, "Servico2"));}
                        }
                )
        );

            add(
                    new Veiculo(3, "Honda", "Sigma", "BR",
                            "2009-10-20",180,2,1400,
                            new ArrayList<Services>(){
                                {
                                    add(new Services(new Date(2019,Calendar.JANUARY,4), 1, "Servico3"));}
                            }
                    )
            );
        }
    };

    public void addVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public Optional<Veiculo> getVeiculoById(int id){
        Optional<Veiculo> veiculo = this.veiculos.stream()
                .filter(v -> v.getId() == id)
                .findFirst();

        return veiculo;
    }

    public List<Veiculo> getVeiculosByPrice(int since, int to) {
        List<Veiculo> veiculos = this.veiculos.stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .collect(Collectors.toList());

        return veiculos;
    }

}

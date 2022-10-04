package br.com.viana.spring3praticaintegradora3.dto;

import br.com.viana.spring3praticaintegradora3.entity.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoDTO {
    private String brand, model, currency;
    private String manufacturingDate;
    private int numberOfKilometers, doors, price;

    public VeiculoDTO(Veiculo veiculo){
        this.brand = veiculo.getBrand();
        this.model = veiculo.getModel();
        this.currency = veiculo.getCurrency();
        this.manufacturingDate = veiculo.getManufacturingDate();
        this.numberOfKilometers = veiculo.getNumberOfKilometers();
        this.doors = veiculo.getDoors();
        this.price = veiculo.getPrice();
    }
}

package br.com.viana.spring3praticaintegradora3.dto;

import br.com.viana.spring3praticaintegradora3.entity.Veiculo;
import br.com.viana.spring3praticaintegradora3.util.NumberGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class VeiculoRequestDTO {
    private String brand, model, currency;
    private String manufacturingDate;
    private int numberOfKilometers, doors, price;

    public Veiculo convertToVeiculo() {
        int id = NumberGenerator.getInstance().getNext();

        return new Veiculo(id,brand,model,currency,manufacturingDate,numberOfKilometers,doors,
                price, null);
    }
}

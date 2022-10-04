package br.com.viana.spring3praticaintegradora3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private int id;
    private String brand, model, currency;
    private String manufacturingDate;
    private int numberOfKilometers, doors, price;
    private List<Services> services;
}

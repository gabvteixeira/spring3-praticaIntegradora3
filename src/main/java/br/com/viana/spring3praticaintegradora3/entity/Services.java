package br.com.viana.spring3praticaintegradora3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    private Date date;
    private int kilometers;
    private String description;
}

package br.com.viana.spring3praticaintegradora3.controller;

import br.com.viana.spring3praticaintegradora3.dto.VeiculoDTO;
import br.com.viana.spring3praticaintegradora3.dto.VeiculoRequestDTO;
import br.com.viana.spring3praticaintegradora3.entity.Veiculo;
import br.com.viana.spring3praticaintegradora3.service.IVeiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/veiculos")
public class VeiculoController {

    @Autowired
    private IVeiculo service;

    @PostMapping
    public ResponseEntity<Void> addVeiculo(@RequestBody VeiculoRequestDTO veiculo){
        this.service.addVeiculo(veiculo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> getVeiculos(){
        return new ResponseEntity<>(this.service.getVeiculos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable int id){
        Veiculo veiculo = this.service.getVeiculoById(id);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VeiculoDTO>> getVeiculoByPrice(@RequestParam Optional<Integer> since, @RequestParam Optional<Integer> to){
        int sinceInt = since.orElse(0);
        int toInt = to.orElse(Integer.MAX_VALUE);
        List<VeiculoDTO> veiculos = this.service.getVeiculosByPrice(sinceInt,toInt);

        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }
}

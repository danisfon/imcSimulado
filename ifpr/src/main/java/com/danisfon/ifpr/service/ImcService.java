package com.danisfon.ifpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danisfon.ifpr.dto.ImcCalculoRequestDTO;
import com.danisfon.ifpr.dto.ImcCalculoResponseDTO;
import com.danisfon.ifpr.model.Imc;
import com.danisfon.ifpr.repository.ImcRepository;

@Service
public class ImcService {
    @Autowired
    private ImcRepository repository;

    public ImcCalculoResponseDTO calcular(ImcCalculoRequestDTO imcRequest) {
        double imc = imcRequest.getPeso() / (imcRequest.getAltura() * imcRequest.getAltura());
        ImcCalculoResponseDTO response = null;

        if (imc < 18.5)
            response = new ImcCalculoResponseDTO(imc, "Baixo peso");
        else if (imc < 24.9)
            response = new ImcCalculoResponseDTO(imc, "Peso normal");
        else if (imc < 29.9)
            response = new ImcCalculoResponseDTO(imc, "Sobrepeso");
        else if (imc < 34.9)
            response = new ImcCalculoResponseDTO(imc, "Obesidade grau I");
        else if (imc < 39.9)
            response = new ImcCalculoResponseDTO(imc, "Obesidade grau II");
        else
            response = new ImcCalculoResponseDTO(imc, "Obesidade grau III");

        return response;
    }

    public Imc salvar(Imc imc) {
        // imc.setDataHora(new Date());
        return repository.save(imc);
    }

    public List<Imc> buscarTodos() {
        return repository.findAll();
    }

    public List<Imc> buscarTodos(String classificacao) {
        return repository.findByClassificacao(classificacao);
    }

    public void removerTodos() {
        repository.deleteAll();
    }
}

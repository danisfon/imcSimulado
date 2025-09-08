package com.danisfon.ifpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danisfon.ifpr.dto.ImcCalculoRequestDTO;
import com.danisfon.ifpr.dto.ImcCalculoResponseDTO;
import com.danisfon.ifpr.model.Imc;
import com.danisfon.ifpr.service.ImcService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/imc")
@CrossOrigin
public class ImcController {
    @Autowired
    private ImcService service;

    @PostMapping("/calcular")
    public ImcCalculoResponseDTO calcular(@Valid @RequestBody ImcCalculoRequestDTO request) {
        return service.calcular(request);
    }

    @PostMapping("/salvar")
    public Imc salvar(@Valid @RequestBody Imc imc) {
        return service.salvar(imc);
    }

    @GetMapping
    public List<Imc> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/classificacao")
    public List<Imc> buscarTodos(@PathParam("classificacao") String classificacao) {
        return service.buscarTodos(classificacao);
    }

    @DeleteMapping
    public void removerTodos() {
        service.removerTodos();
    }
}

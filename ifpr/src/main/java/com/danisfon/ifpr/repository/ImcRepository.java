package com.danisfon.ifpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danisfon.ifpr.model.Imc;

public interface ImcRepository extends JpaRepository<Imc, Long> {
    public List<Imc> findByClassificacao(String classificacao);
}


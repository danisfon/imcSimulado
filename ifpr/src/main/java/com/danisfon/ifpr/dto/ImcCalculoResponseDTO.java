package com.danisfon.ifpr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImcCalculoResponseDTO {
    private double imc;
    private String classificacao;
}

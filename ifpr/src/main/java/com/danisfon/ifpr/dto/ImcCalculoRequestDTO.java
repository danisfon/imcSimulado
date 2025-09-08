package com.danisfon.ifpr.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ImcCalculoRequestDTO {
    @Positive(message="O peso precisa ser posistivo")
    private double peso;
    @Positive(message="A altura precisa ser posistiva")
    private double altura;
}

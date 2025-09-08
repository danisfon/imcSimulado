package com.danisfon.ifpr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="imc")
@Data
public class Imc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="O nome é obrigatorio")
    private String nome;
    @Positive(message="O peso precisa ser posistivo")
    private double peso;
    @Positive(message="A altura precisa ser posistiva")
    private double altura;
    private double imc;
    private String classificacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora = new Date();
}


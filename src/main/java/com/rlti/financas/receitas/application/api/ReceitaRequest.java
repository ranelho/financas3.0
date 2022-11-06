package com.rlti.financas.receitas.application.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Categoria;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class ReceitaRequest {
    @NotNull
    private String descricao;
    @NotNull
    private Categoria categoria;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataReceita;
    @NotNull
    private Double valor;
}

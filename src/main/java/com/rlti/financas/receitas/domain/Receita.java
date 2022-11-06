package com.rlti.financas.receitas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.receitas.application.api.ReceitaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Receita {
    @Id
    private UUID idReceita;
    @NotNull
    private String descricao;
    @NotNull
    private Categoria categoria;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataReceita;
    @NotNull
    private Double valor;

    public Receita(ReceitaRequest receitaRequest){
        this.idReceita = UUID.randomUUID();
        this.descricao = receitaRequest.getDescricao();
        this.categoria = receitaRequest.getCategoria();
        this.dataReceita = receitaRequest.getDataReceita();
        this.valor = receitaRequest.getValor();
    }
}

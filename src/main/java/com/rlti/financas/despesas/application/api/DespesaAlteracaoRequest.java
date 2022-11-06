package com.rlti.financas.despesas.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Situacao;

import lombok.Value;

@Value
public class DespesaAlteracaoRequest {
	@NotNull
	private String descricao;
	@NotNull
	private Categoria categoria;
	private int parcelas;
	@NotNull
	private LocalDate dataPagamento;
	@NotNull
	private Double valor;
	@NotNull
	private Situacao situacao;
}

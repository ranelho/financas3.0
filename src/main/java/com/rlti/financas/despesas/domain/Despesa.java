package com.rlti.financas.despesas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.application.api.DespesaAlteracaoRequest;
import com.rlti.financas.despesas.application.api.DespesaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Despesa {
	@Id
	private UUID idDespesa;
	@NotNull
	private Categoria categoria;
	@NotNull
	private String descricao;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	@NotNull
	private int quantidadeParcelas;
	@NotNull
	private Double valorTotal;

	public Despesa(DespesaRequest despesaRequest) {
		this.idDespesa = UUID.randomUUID();
		this.categoria = despesaRequest.getCategoria();
		this.descricao = despesaRequest.getDescricao();
		this.dataPagamento = despesaRequest.getDataPagamento();
		this.quantidadeParcelas = despesaRequest.getQuantidadeParcelas();
		this.valorTotal = despesaRequest.getValorTotal();
	}
	public void altera(@Valid DespesaAlteracaoRequest despesaAlteracaoRequest) {
		this.categoria = despesaAlteracaoRequest.getCategoria();
		this.quantidadeParcelas = despesaAlteracaoRequest.getParcelas();
		this.valorTotal = despesaAlteracaoRequest.getValor();
	}
}

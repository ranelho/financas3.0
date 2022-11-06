package com.rlti.financas.despesas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class DespesaDetalhadoResponse {
	private UUID idDespesa;
	private Categoria categoria;
	private int quantidadeParcelas;
	private Double valorTotal;
	private List<Parcela> parcelas;
	public DespesaDetalhadoResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.quantidadeParcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
		this.parcelas = despesa.getParcelas();
	}
}

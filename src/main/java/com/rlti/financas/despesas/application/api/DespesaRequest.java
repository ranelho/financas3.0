package com.rlti.financas.despesas.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.rlti.financas.despesas.domain.Categoria;

import com.rlti.financas.parcelas.domain.Parcela;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DespesaRequest {
	private UUID idDespesa;
	private Categoria categoria;
	private String descricao;
	private LocalDate dataPagamento;
	private int quantidadeParcelas;
	private Double valorTotal;
	private List<Parcela> parcelas;
}


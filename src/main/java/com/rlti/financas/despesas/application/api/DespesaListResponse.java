package com.rlti.financas.despesas.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.parcelas.domain.Parcela;
import org.springframework.http.HttpStatus;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.handler.APIException;

import lombok.Value;

@Value
public class DespesaListResponse {
	private UUID idDespesa;
	private Categoria categoria;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	private int quantidadeParcelas;
	private Double valorTotal;
	private List<Parcela> parcelas;
	public static List<DespesaListResponse> converte(List<Despesa> despesas) {
		if (despesas.isEmpty()) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Nenhuma tarefa econtrada!");
		} else {
			return despesas.stream()
					.map(DespesaListResponse::new)
					.collect(Collectors.toList());
		}
	}
	private DespesaListResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.dataPagamento = despesa.getDataPagamento();
		this.quantidadeParcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
		this.parcelas = despesa.getParcelas();
	}
}

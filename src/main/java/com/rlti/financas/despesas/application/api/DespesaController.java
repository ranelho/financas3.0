package com.rlti.financas.despesas.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import org.springframework.web.bind.annotation.RestController;

import com.rlti.financas.despesas.application.service.DespesaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class DespesaController implements DespesaApi {
	private final DespesaService despesaService;

	@Override
	public DespesaResponse postDespesa(@Valid DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] DespesaController - postDespesa");
		DespesaResponse despesaCriada = despesaService.criaDespesa(despesaRequest, parcelaRequest);
		log.info("[finaliza] DespesaController - postDespesa");		
		return despesaCriada;
	}
	@Override
	public DespesaDetalhadoResponse getDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] DespesaController - getDespesaAtravesId");
		Despesa despesa = despesaService.buscaDespesaAtravesId(idDespesa);
		log.info("[finaliza] DespesaController - getDespesaAtravesId");
		return new DespesaDetalhadoResponse(despesa);
	}
}

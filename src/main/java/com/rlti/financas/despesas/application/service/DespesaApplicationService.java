package com.rlti.financas.despesas.application.service;

import com.rlti.financas.despesas.application.api.DespesaAlteracaoRequest;
import com.rlti.financas.despesas.application.api.DespesaListResponse;
import com.rlti.financas.despesas.application.api.DespesaRequest;
import com.rlti.financas.despesas.application.api.DespesaResponse;
import com.rlti.financas.despesas.application.repository.DespesaRepository;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.domain.ValidaMes;
import com.rlti.financas.handler.APIException;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class DespesaApplicationService implements DespesaService {
	private final DespesaRepository despesaRepository;
	private final ParcelaRepository parcelaRepository;

	String statusParcela;
	LocalDate dataPagamento;

	@Override
	public DespesaResponse criaDespesa(DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] - DespesaApplicationService - criaDespesa");
		Despesa despesas = despesaRepository.salva(new Despesa(despesaRequest));
		double valorParcela = despesaRequest.getValorTotal() / despesaRequest.getQuantidadeParcelas();
		for (int count = 1; count <= despesaRequest.getQuantidadeParcelas(); count++) {
			statusParcela = count + "/" + despesaRequest.getQuantidadeParcelas();
			parcelaRequest.setValorParcela(valorParcela);
			parcelaRequest.setDataParcela(ValidaMes.validaMes(despesaRequest.getDataPagamento(), count));
			parcelaRequest.setDescricao(despesaRequest.getDescricao());
			parcelaRequest.setQuantidadeParcelas(statusParcela);
			parcelaRepository.salva(new Parcela(despesas.getIdDespesa(),parcelaRequest));
			log.info("[finaliza] - DespesaApplicationService - criaDespesa");
		}
		return DespesaResponse.builder().idDespesa(despesas.getIdDespesa()).build();
	}

	@Override
	public Despesa buscaDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] - DespesaApplicationService - buscaDespesaAtravesId");
		Despesa despesa = despesaRepository.buscaDespesaPorId(idDespesa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Despesa não encontrada!"));
		log.info("[finaliza] - DespesaApplicationService - buscaDespesaAtravesId");
		return despesa;
	}
}


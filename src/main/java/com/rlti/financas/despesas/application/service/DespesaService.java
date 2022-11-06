package com.rlti.financas.despesas.application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.rlti.financas.despesas.application.api.DespesaAlteracaoRequest;
import com.rlti.financas.despesas.application.api.DespesaListResponse;
import com.rlti.financas.despesas.application.api.DespesaRequest;
import com.rlti.financas.despesas.application.api.DespesaResponse;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;

public interface DespesaService {
	DespesaResponse criaDespesa(DespesaRequest despesaRequest, ParcelaRequest parcelaRequest);
	Despesa buscaDespesaAtravesId(UUID idDespesa);
}

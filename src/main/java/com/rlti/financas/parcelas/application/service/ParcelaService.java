package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.parcelas.application.api.ParcelaDetalhadoResponse;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.domain.Parcela;

import java.util.List;
import java.util.UUID;

public interface ParcelaService {
    ParcelaIdResponse criarParcela(UUID idDespesa, ParcelaRequest parcelaRequest);
    List<ParcelaListResponse> getParcelasDespesa(UUID idDespesa);
    List<ParcelaListResponse> getAllParcelas();
    void deleteParcela(UUID idParcela);
    Parcela buscaParcelaId(UUID idParcela);
}

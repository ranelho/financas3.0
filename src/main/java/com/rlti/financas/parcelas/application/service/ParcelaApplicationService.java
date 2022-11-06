package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.despesas.application.repository.DespesaRepository;
import com.rlti.financas.handler.APIException;
import com.rlti.financas.parcelas.application.api.ParcelaDetalhadoResponse;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ParcelaApplicationService implements ParcelaService {
    private final ParcelaRepository parcelaRepository;
    private final DespesaRepository despesaRepository;

    @Override
    public ParcelaIdResponse criarParcela(UUID idDespesa, ParcelaRequest parcelaRequest) {
        log.info("[inicia] ParcelaApplicationService - criarParcela");
        Parcela parcela = parcelaRepository.salva(new Parcela(idDespesa, parcelaRequest));
        log.info("[finaliza] ParcelaApplicationService - criarParcela");
        return null;
    }

    @Override
    public List<ParcelaListResponse> getParcelasDespesa(UUID idDespesa) {
        log.info("[inicia] ParcelaApplicationService - getParcelasDespesa");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasDespesa(idDespesa);
        log.info("[finaliza] ParcelaApplicationService - getParcelasDespesa");
        return ParcelaListResponse.converte(parcelas);
    }

    @Override
    public List<ParcelaListResponse> getAllParcelas() {
        log.info("[inicia] ParcelaApplicationService - getAllParcelas");
        List<Parcela> parcelas = parcelaRepository.findAllParcelas();
        log.info("[finaliza] ParcelaApplicationService - getAllParcelas");
        return ParcelaListResponse.converte(parcelas);
    }

    @Override
    public void deleteParcela(UUID idParcela) {
        log.info("[inicia] ParcelaApplicationService - deleteParcela");
        buscaParcelaId(idParcela);
        parcelaRepository.deletaParcela(idParcela);
        log.info("[finaliza] ParcelaApplicationService - deleteParcela");
    }

    @Override
    public Parcela buscaParcelaId(UUID idParcela) {
        log.info("[inicia] ParcelaApplicationService - buscaParcelaId");
        Parcela parcela = parcelaRepository.buscaParcelaId(idParcela)
                .orElseThrow(()-> APIException.build(HttpStatus.BAD_REQUEST, "Parcela não encontrado!"));
        log.info("[finaliza] ParcelaApplicationService - buscaParcelaId");
        return parcela;
    }
}

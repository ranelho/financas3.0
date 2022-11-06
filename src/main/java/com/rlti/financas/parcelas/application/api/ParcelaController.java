package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.parcelas.application.service.ParcelaService;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ParcelaController implements ParcelaApi {
    private final ParcelaService parcelaService;

    @Override
    public ParcelaIdResponse postParcela(UUID idDespesa, ParcelaRequest parcelaRequest) {
        log.info("[inicia] ParcelaController - postParcela");
        ParcelaIdResponse parcelaCriada = parcelaService.criarParcela(idDespesa, parcelaRequest);
        log.info("[finaliza] ParcelaController - postParcela");
        return parcelaCriada;
    }

    @Override
    public List<ParcelaListResponse> getTodasParcelasDespesa(UUID idDespesa) {
        log.info("[inicia] ParcelaController - getTodasParcelasDespesa");
        List<ParcelaListResponse> todasParcelas = parcelaService.getParcelasDespesa(idDespesa);
        log.info("[finaliza] ParcelaController - getTodasParcelasDespesa");
        return todasParcelas;
    }

    @Override
    public List<ParcelaListResponse> getTodasParcelas() {
        log.info("[inicia] ParcelaController - getTodasParcelas");
        List<ParcelaListResponse> parcelas = parcelaService.getAllParcelas();
        log.info("[finaliza] ParcelaController - getTodasParcelas");
        return parcelas;
    }

    @Override
    public void deleteParcela(UUID idParcela) {
        log.info("[inicia] ParcelaController - deleteParcela");
        parcelaService.deleteParcela(idParcela);
        log.info("[finaliza] ParcelaController - deleteParcela");
    }

    @Override
    public ParcelaDetalhadoResponse getParcelaAtravesId(UUID idParcela) {
        log.info("[inicia] ParcelaController - getParcelaAtravesId");
        Parcela parcela = parcelaService.buscaParcelaId(idParcela);
        log.info("[finaliza] ParcelaController - getParcelaAtravesId");
        return new ParcelaDetalhadoResponse(parcela);
    }
}

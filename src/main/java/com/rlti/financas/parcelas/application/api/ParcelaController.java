package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.parcelas.application.service.ParcelaService;
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
}

package com.rlti.financas.parcelas.infra;

import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ParcelaInfraRepository implements ParcelaRepository {
    private final ParcelaMongoRepository parcelaMongoRepository;

    @Override
    public Parcela salva(Parcela parcela) {
        log.info("[inicia] ParcelaInfraRepository - salva");
        parcelaMongoRepository.save(parcela);
        log.info("[finaliza] ParcelaInfraRepository - salva");
        return null;
    }
}

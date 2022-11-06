package com.rlti.financas.parcelas.infra;

import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
    @Override
    public List<Parcela> buscaParcelasDespesa(UUID idDespesa) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasDespesa");
        List<Parcela> parcelas = parcelaMongoRepository.findAllByIdDespesa(idDespesa);
        log.info("[finaliza] ParcelaInfraRepository - buscaParcelasDespesa");
        return parcelas;
    }
    @Override
    public List<Parcela> findAllParcelas() {
        log.info("[inicia] ParcelaInfraRepository - findAllParcelas");
        List<Parcela> parcelas = parcelaMongoRepository.findAll();
        log.info("[finaliza] ParcelaInfraRepository - findAllParcelas");
        return parcelas;
    }
    @Override
    public void deletaParcela(UUID idParcela) {
        log.info("[inicia] ParcelaInfraRepository - deletaParcela");
        parcelaMongoRepository.deleteById(idParcela);
        log.info("[finaliza] ParcelaInfraRepository - deletaParcela");
    }
    @Override
    public Optional<Parcela> buscaParcelaId(UUID idParcela) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelaId");
        Optional<Parcela> parcela = parcelaMongoRepository.findById(idParcela);
        log.info("[finaliza] ParcelaInfraRepository - buscaParcelaId");
        return parcela;
    }
}

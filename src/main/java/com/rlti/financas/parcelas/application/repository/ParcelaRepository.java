package com.rlti.financas.parcelas.application.repository;

import com.rlti.financas.parcelas.domain.Parcela;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParcelaRepository {
    Parcela salva(Parcela parcela);
    List<Parcela> buscaParcelasDespesa(UUID idDespesa);
    List<Parcela> findAllParcelas();
    void deletaParcela(UUID idParcela);
    Optional<Parcela> buscaParcelaId(UUID idParcela);
}

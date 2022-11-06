package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ReceitaInfraRepository implements ReceitaRepository {
    private final ReceitaMongoRepository receitaMongoRepository;

    @Override
    public Receita salva(Receita receita) {
       log.info("[inicia] ReceitaInfraRepository - salva");
       receitaMongoRepository.save(receita);
       log.info("[finaliza] ReceitaInfraRepository - salva");
       return receita;
    }

    @Override
    public List<Receita> getReceitas() {
        log.info("[inicia] ReceitaInfraRepository - getReceitas");
        List<Receita> receitas = receitaMongoRepository.findAll();
        log.info("[finaliza] ReceitaInfraRepository - getReceitas");
        return receitas;
    }

    @Override
    public void deleta(UUID idReceita) {
        log.info("[inicia] - ReceitaInfraRepository - deleta");
        receitaMongoRepository.deleteById(idReceita);
        log.info("[finaliza] - ReceitaInfraRepository - deleta");
    }

    @Override
    public Optional<Receita> buscaReceitaPorId(UUID idReceita) {
        log.info("[inicia] - ReceitaInfraRepository - buscaReceitaPorId");
        Optional<Receita> receitaPorId = receitaMongoRepository.findById(idReceita);
        log.info("[finaliza] - ReceitaInfraRepository - buscaReceitaPorId");
        return receitaPorId;
    }
}

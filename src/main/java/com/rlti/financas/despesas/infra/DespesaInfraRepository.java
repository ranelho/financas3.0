package com.rlti.financas.despesas.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.rlti.financas.despesas.application.repository.DespesaRepository;
import com.rlti.financas.despesas.domain.Despesa;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class DespesaInfraRepository implements DespesaRepository {
	private final DespesaMongoRepository despesaMongoRepository;

	@Override
	public Despesa salva(Despesa despesas) {
		log.info("[inicia] - DespesaInfraRepository - salva");
		despesaMongoRepository.save(despesas);
		log.info("[finaliza] - DespesaInfraRepository - salva");
		return despesas;
	}

	@Override
	public Optional<Despesa> buscaDespesaPorId(UUID idDespesa) {
		log.info("[inicia] DespesaInfraRepository - buscaDespesaPorId");
		Optional<Despesa> despesa = despesaMongoRepository.findById(idDespesa);
		log.info("[final] DespesaInfraRepository - buscaDespesaPorId");
		return despesa;

	}
    @Override
    public List<Despesa> findDespesas() {
		log.info("[inicia] DespesaInfraRepository - findDespesas");
		List<Despesa> despesa = despesaMongoRepository.findAll();
		log.info("[finaliza] DespesaInfraRepository - findDespesas");
		return despesa;
    }
	@Override
	public void deletaDespesa(UUID idDespesa) {
		log.info("[inicia] DespesaInfraRepository - deletaDespesa");
		despesaMongoRepository.deleteById(idDespesa);
		log.info("[finaliza] DespesaInfraRepository - deletaDespesa");
	}
}

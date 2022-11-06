package com.rlti.financas.despesas.application.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rlti.financas.despesas.domain.Despesa;

public interface DespesaRepository {
	Despesa salva(Despesa despesa);
	Optional<Despesa> buscaDespesaPorId(UUID idDespesa);
    List<Despesa> findDespesas();
	void deletaDespesa(UUID idDespesa);
}

package com.rlti.financas.despesas.infra;

import com.rlti.financas.despesas.domain.Despesa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DespesaMongoRepository extends MongoRepository<Despesa, UUID> {
}

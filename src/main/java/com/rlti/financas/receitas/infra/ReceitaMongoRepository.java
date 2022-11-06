package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.domain.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ReceitaMongoRepository extends MongoRepository<Receita, UUID> {
}

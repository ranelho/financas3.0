package com.rlti.financas.parcelas.infra;

import com.rlti.financas.parcelas.domain.Parcela;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ParcelaMongoRepository extends MongoRepository<Parcela, UUID> {
}

package com.rlti.financas.receitas.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ReceitaIdResponse {
    private UUID idReceita;
}

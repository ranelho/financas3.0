package com.rlti.financas.despesas.application.api;

import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v3/despesa")
public interface DespesaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DespesaResponse postDespesa(@Valid @RequestBody DespesaRequest despesaRequest, ParcelaRequest parcelaRequest);

    @GetMapping(value = "/{idDespesa}")
    @ResponseStatus(code = HttpStatus.OK)
    DespesaDetalhadoResponse getDespesaAtravesId(@PathVariable UUID idDespesa);
}
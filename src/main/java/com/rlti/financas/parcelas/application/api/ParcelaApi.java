package com.rlti.financas.parcelas.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v3/parcelas/")
public interface ParcelaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParcelaIdResponse postParcela(@PathVariable UUID idDespesa, @Valid @RequestBody ParcelaRequest parcelaRequest);
}

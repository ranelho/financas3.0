package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.application.api.DespesaDetalhadoResponse;
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

    @GetMapping(value = "/allParcelasDespesa/")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getTodasParcelasDespesa(@RequestParam UUID idDespesa);

    @GetMapping(value = "/allParcelas")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getTodasParcelas();

    @DeleteMapping("/{idParcela}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteParcela(@PathVariable UUID idParcela);

    @GetMapping(value = "/{idParcela}")
    @ResponseStatus(code = HttpStatus.OK)
    ParcelaDetalhadoResponse getParcelaAtravesId(@PathVariable UUID idParcela);
}

package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.domain.Situacao;
import com.rlti.financas.handler.APIException;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ParcelaListResponse {
    private UUID idParcela;
    private String descricao;
    private String quantidadeParcelas;
    private Double valorParcela;
    private LocalDate dataParcela;
    private Situacao situacao ;

    public ParcelaListResponse(Parcela parcela) {
        this.idParcela = parcela.getIdParcela();
        this.descricao = parcela.getDescricao();
        this.quantidadeParcelas = parcela.getQuantidadeParcelas();
        this.valorParcela = parcela.getValorParcela();
        this.dataParcela = parcela.getDataParcela();
        this.situacao = parcela.getSituacao();
    }

    public static List<ParcelaListResponse> converte(List<Parcela> parcelas) {
            return parcelas.stream()
                    .map(ParcelaListResponse::new)
                    .collect(Collectors.toList());
    }
}

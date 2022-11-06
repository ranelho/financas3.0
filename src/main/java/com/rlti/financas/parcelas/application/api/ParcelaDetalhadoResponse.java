package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.domain.Situacao;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
public class ParcelaDetalhadoResponse {
    private String descricao;
    private String quantidadeParcelas;
    private Double valorParcela;
    private LocalDate dataParcela;
    private Situacao situacao ;
    private UUID idDespesa;

    public ParcelaDetalhadoResponse(Parcela parcela) {
        this.descricao = parcela.getDescricao();
        this.quantidadeParcelas = parcela.getQuantidadeParcelas();
        this.valorParcela = parcela.getValorParcela();
        this.dataParcela = parcela.getDataParcela();
        this.situacao = parcela.getSituacao();
        this.idDespesa = parcela.getIdDespesa();
    }
}

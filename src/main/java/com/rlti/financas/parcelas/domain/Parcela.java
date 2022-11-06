package com.rlti.financas.parcelas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Situacao;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Parcela {
    @Id
    private UUID idParcela;
    @NotNull
    private String descricao;
    @NotNull
    private String quantidadeParcelas;
    @NotNull
    private Double valorParcela;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataParcela;
    @NotNull
    private Situacao situacao = Situacao.A_PAGAR ;
    @NotNull
    private UUID despesaId;

    public Parcela(UUID idDespesa, ParcelaRequest parcelaRequest) {
        this.idParcela = UUID.randomUUID();
        this.descricao = parcelaRequest.getDescricao();
        this.quantidadeParcelas = parcelaRequest.getQuantidadeParcelas();
        this.valorParcela = parcelaRequest.getValorParcela();
        this.dataParcela = parcelaRequest.getDataParcela();
        this.situacao = Situacao.A_PAGAR;
        this.despesaId = idDespesa;
    }

    public void pago(UUID idDespesa) {
		this.situacao = Situacao.PAGO;
    }
    public void aPagar(UUID idDespesa) {
        this.situacao = Situacao.A_PAGAR;
	}
}

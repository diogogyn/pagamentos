package com.dos.pagamentos.dto;

import com.dos.pagamentos.enums.Status;
import com.dos.pagamentos.model.Pagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDto {
    public PagamentoDto(Pagamento pagamento){
        this.id = pagamento.getId();
        this.valor = pagamento.getValor();
        this.nome = pagamento.getNome();
        this.numero = pagamento.getNumero();
        this.expiracao = pagamento.getExpiracao();
        this.codigo = pagamento.getCodigo();
        this.status = pagamento.getStatus();
        this.formaDePagamentoId = pagamento.getFormaDePagamentoId();
        this.pedidoId = pagamento.getPedidoId();
    }
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long formaDePagamentoId;
    private Long pedidoId;


}
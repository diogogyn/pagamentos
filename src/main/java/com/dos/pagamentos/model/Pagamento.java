package com.dos.pagamentos.model;

import com.dos.pagamentos.dto.PagamentoDto;
import com.dos.pagamentos.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    public Pagamento(PagamentoDto pagamento){
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max=100)
    private String nome;

    @NotBlank
    @Size(max=19)
    private String numero;

    @NotBlank
    @Size(max=7)
    private String expiracao;

    @NotBlank
    @Size(min=3, max=3)
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long pedidoId;

    @NotNull
    private Long formaDePagamentoId;
}

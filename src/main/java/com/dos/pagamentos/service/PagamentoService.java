package com.dos.pagamentos.service;

import com.dos.pagamentos.dto.PagamentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoService {
    public Page<PagamentoDto> obterTodos(Pageable paginacao);
    public PagamentoDto obterPorId(Long id);
    public PagamentoDto criarPagamento(PagamentoDto dto);
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto);
    public void excluirPagamento(Long id);
    public void confirmarPagamento(Long id);

    void alteraStatus(Long id);
}

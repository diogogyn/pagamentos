package com.dos.pagamentos.service.impl;

import com.dos.pagamentos.dto.PagamentoDto;
import com.dos.pagamentos.enums.Status;
import com.dos.pagamentos.model.Pagamento;
import com.dos.pagamentos.repository.PagamentoRepository;
import com.dos.pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Autowired
    private PagamentoRepository repository;
    @Override
    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return this.repository
                .findAll(paginacao)
                .map(p -> new PagamentoDto(p));
    }
    @Override
    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return new PagamentoDto(pagamento);
    }
    @Override
    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = new Pagamento(dto);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);
        return new PagamentoDto(pagamento);
    }
    @Override
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = new Pagamento(dto);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return new PagamentoDto(pagamento);
    }
    @Override
    public void excluirPagamento(Long id) {
        this.repository.deleteById(id);
    }
    
}

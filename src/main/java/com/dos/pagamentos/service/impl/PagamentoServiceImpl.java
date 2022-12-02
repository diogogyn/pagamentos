package com.dos.pagamentos.service.impl;

import com.dos.pagamentos.dto.PagamentoDto;
import com.dos.pagamentos.enums.Status;
import com.dos.pagamentos.model.Pagamento;
import com.dos.pagamentos.repository.PagamentoRepository;
import com.dos.pagamentos.service.PagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PagamentoRepository repository;
    @Override
    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return this.repository
                .findAll(paginacao)
                .map(p -> this.modelMapper.map(p, PagamentoDto.class));
    }
    @Override
    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return this.modelMapper.map(pagamento, PagamentoDto.class);
    }
    @Override
    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = this.modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        this.repository.save(pagamento);
        return this.modelMapper.map(pagamento, PagamentoDto.class);
    }
    @Override
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = this.modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = this.repository.save(pagamento);
        return this.modelMapper.map(pagamento, PagamentoDto.class);
    }
    @Override
    public void excluirPagamento(Long id) {
        this.repository.deleteById(id);
    }
    
}

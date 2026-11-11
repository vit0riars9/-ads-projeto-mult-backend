package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;

@Service
public class LancamentoService {
    private final LancamentoRepository repository;

    public LancamentoService(LancamentoRepository repository) {
        this.repository = repository;
    }

    public List<Lancamento> listar() {
        return repository.findAll();
    }

    public Lancamento salvar(Lancamento categoria) {
        return repository.save(categoria);
    }
    
    public Lancamento buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public Lancamento atualizar(Long id, Lancamento lancamento) {
        Lancamento lancamentoBanco = repository.findById(id).orElse(null);
        if (lancamentoBanco == null) {
            return null;
        }
        lancamentoBanco.setId(lancamento.getId());
        lancamentoBanco.setDescricao(lancamento.getDescricao());
        lancamentoBanco.setValor(lancamento.getValor());
        lancamentoBanco.setDataLancamento(lancamento.getDataLancamento());
        lancamentoBanco.setObservacao(lancamento.getObservacao());
        lancamentoBanco.setCategoria(lancamento.getCategoria());
        lancamentoBanco.setUsuario(lancamento.getUsuario());
   
        return repository.save(lancamentoBanco);
    }

    public boolean excluir(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}


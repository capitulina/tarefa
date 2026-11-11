package com.insper.tarefa.Tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    @Transactional
    public Tarefa criar(Tarefa tarefa) {
        // O servidor controla identidade e data da criação.
        tarefa.setId(null);

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return tarefaSalva;
    }
    public Tarefa buscarPorId(Integer id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    @Transactional
    public void excluir(Integer id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }
}

package com.example.loja.service;

import com.example.loja.model.Categoria;
import com.example.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setNome(categoriaAtualizada.getNome());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
package com.projetoFinal.Projeto.Final.model.produtos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}

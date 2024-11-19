package com.projetoFinal.Projeto.Final.model.fichas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FichasRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByUsuarioNome(String nome);
    List<Ficha> findByProdutoNome(String nome);
    @Query(value = "SELECT * FROM fichas f WHERE f.data_ficha = :data", nativeQuery = true)
    List<Ficha> findByDataFicha(@Param("data") LocalDate data);
}

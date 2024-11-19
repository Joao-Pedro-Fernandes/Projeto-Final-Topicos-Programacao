package com.projetoFinal.Projeto.Final.model.usuarios;

import com.projetoFinal.Projeto.Final.model.produtos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    //JPQL
    @Query("SELECT count(u) FROM Usuario u")
    Long findQtdUsuarios();
}

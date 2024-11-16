package com.projetoFinal.Projeto.Final.model.usuarios;

import java.time.LocalDate;

public record AlteraUsuarios(Long id,String nome, String cpf, String email, LocalDate dataNascimento, Long contato) {
}

package com.projetoFinal.Projeto.Final.model.usuarios;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private Long contato;

    public Usuario() {
    }

    public Usuario(CadastroUsuario Usuario) {
        this.nome = Usuario.nome();
        this.cpf = Usuario.cpf();
        this.contato = Usuario.contato();
        this.email = Usuario.email();
        this.dataNascimento = Usuario.dataNascimento();
    }

    public void atualizaUsuario(AlteraUsuarios Usuario) {
        this.nome = Usuario.nome();
        this.cpf = Usuario.cpf();
        this.contato = Usuario.contato();
        this.email = Usuario.email();
        this.dataNascimento = Usuario.dataNascimento();
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getContato() {
        return contato;
    }
}
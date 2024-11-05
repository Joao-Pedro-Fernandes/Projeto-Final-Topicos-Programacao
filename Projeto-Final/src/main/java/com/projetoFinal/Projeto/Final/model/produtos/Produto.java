package com.projetoFinal.Projeto.Final.model.produtos;

import com.projetoFinal.Projeto.Final.controller.AlteraProdutos;
import jakarta.persistence.*;

@Entity
@Table(name="Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String classe;

    public Produto(){}

    public Produto(CadastroProduto produto)
    {
        this.nome = produto.nome();
        this.classe = produto.classe();
    }

    public void atualizaProduto(AlteraProdutos dados)
    {
        this.nome = dados.nome();
        this.classe = dados.classe();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }
}

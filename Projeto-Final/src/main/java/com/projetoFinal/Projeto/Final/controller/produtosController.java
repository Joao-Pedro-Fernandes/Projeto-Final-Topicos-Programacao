package com.projetoFinal.Projeto.Final.controller;

import com.projetoFinal.Projeto.Final.model.produtos.AlteraProdutos;
import com.projetoFinal.Projeto.Final.model.produtos.CadastroProduto;
import com.projetoFinal.Projeto.Final.model.produtos.Produto;
import com.projetoFinal.Projeto.Final.model.produtos.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class produtosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping("/lista")
    public String listaProdutos(Model model)
    {
        model.addAttribute("produtos", repository.findAll());
        model.addAttribute("qtdProdutos", repository.findQtdProdutos());

        return "/produtos/lista";
    }

    @PostMapping("/formulario")
    public String cadastrarProduto(CadastroProduto produto)
    {
        Produto p = new Produto(produto);
        repository.save(p);
        return "redirect:/produtos/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model)
    {
        if (id != null)
        {
            Produto p1 = repository.getReferenceById(id);
            model.addAttribute("produto", p1);
        }
        return "/produtos/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraProduto(AlteraProdutos produtos)
    {
        Produto p1 = repository.getReferenceById(produtos.id());
        p1.atualizaProduto(produtos);
        repository.save(p1);
        return "redirect:/produtos/lista";
    }

    @DeleteMapping("/excluir")
    @Transactional
    public String removeProduto(Long id)
    {
        repository.deleteById(id);
        return "redirect:/produtos/lista";
    }

}

package com.projetoFinal.Projeto.Final.controller;


import com.projetoFinal.Projeto.Final.model.fichas.AlteraFichas;
import com.projetoFinal.Projeto.Final.model.fichas.CadastroFicha;
import com.projetoFinal.Projeto.Final.model.fichas.Ficha;
import com.projetoFinal.Projeto.Final.model.fichas.FichasRepository;
import com.projetoFinal.Projeto.Final.model.produtos.ProdutosRepository;
import com.projetoFinal.Projeto.Final.model.usuarios.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/fichas")
public class fichaController {
    @Autowired
    private ProdutosRepository repositoryProduto;
    @Autowired
    private UsuariosRepository repositoryUsuario;
    @Autowired
    private FichasRepository repository;

    @GetMapping("/lista")
    public String listaFichas(Model model)
    {
        model.addAttribute("fichas", repository.findAll());
        return "/fichas/lista";
    }

    @PostMapping("/formulario")
    public String cadastrarFicha(CadastroFicha ficha)
    {
        Ficha p = new Ficha(ficha);
        p.setDataFicha(LocalDate.now());
        repository.save(p);
        return "redirect:/fichas/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model)
    {
        if (id != null)
        {
            Ficha p1 = repository.getReferenceById(id);
            model.addAttribute("fichas", p1);
        }

        model.addAttribute("produtos", repositoryProduto.findAll());
        model.addAttribute("usuarios", repositoryUsuario.findAll());

        return "/fichas/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraFicha(AlteraFichas fichas)
    {
        Ficha p1 = repository.getReferenceById(fichas.id());
        p1.atualizaFicha(fichas);
        repository.save(p1);
        return "redirect:/fichas/lista";
    }

    @DeleteMapping("/excluir")
    @Transactional
    public String removeFicha(Long id)
    {
        repository.deleteById(id);
        return "redirect:/fichas/lista";
    }

    @GetMapping("/buscarNomeUsuario")
    public String listarFichas(@RequestParam(value = "nome", required = false) String nome, Model model) {
        List<Ficha> fichas;

        if (nome == null || nome.isEmpty()) {
            fichas = repository.findAll();
        } else {
            fichas = repository.findByUsuarioNome(nome);
        }

        model.addAttribute("lista", fichas);
        return "/fichas/buscarNomeUsuario";
    }

    @GetMapping("/buscarNomeProduto")
    public String listarFichasProduto(@RequestParam(value = "nome", required = false) String nome, Model model) {
        List<Ficha> fichas;

        if (nome == null || nome.isEmpty()) {
            fichas = repository.findAll();
        } else {
            fichas = repository.findByProdutoNome(nome);
        }
        model.addAttribute("lista", fichas);
        return "/fichas/buscarNomeProduto";
    }

    @GetMapping("/buscarDataFicha")
    public String listarFichasData(@RequestParam(value = "data", required = false)
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
                                   Model model) {

        List<Ficha> fichas;

        if (data == null) {
            fichas = repository.findAll();
        } else {
            fichas = repository.findByDataFicha(data);
        }

        model.addAttribute("lista", fichas);
        return "/fichas/buscarDataFicha";
    }


}

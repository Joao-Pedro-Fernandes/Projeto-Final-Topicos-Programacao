package com.projetoFinal.Projeto.Final.controller;


import com.projetoFinal.Projeto.Final.model.fichas.AlteraFichas;
import com.projetoFinal.Projeto.Final.model.fichas.CadastroFicha;
import com.projetoFinal.Projeto.Final.model.fichas.Ficha;
import com.projetoFinal.Projeto.Final.model.fichas.FichasRepository;
import com.projetoFinal.Projeto.Final.model.produtos.ProdutosRepository;
import com.projetoFinal.Projeto.Final.model.usuarios.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
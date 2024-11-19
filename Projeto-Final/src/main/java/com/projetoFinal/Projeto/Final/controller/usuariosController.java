package com.projetoFinal.Projeto.Final.controller;

import com.projetoFinal.Projeto.Final.model.usuarios.AlteraUsuarios;
import com.projetoFinal.Projeto.Final.model.usuarios.CadastroUsuario;
import com.projetoFinal.Projeto.Final.model.usuarios.Usuario;
import com.projetoFinal.Projeto.Final.model.usuarios.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class usuariosController {
    @Autowired
    private UsuariosRepository repository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model)
    {
        model.addAttribute("qtdUsuarios", repository.findQtdUsuarios());
        model.addAttribute("usuarios", repository.findAll());
        return "/usuarios/lista";
    }

    @PostMapping("/formulario")
    public String cadastrarUsuario(CadastroUsuario usuario)
    {
        Usuario p = new Usuario(usuario);
        repository.save(p);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model)
    {
        if (id != null)
        {
            Usuario p1 = repository.getReferenceById(id);
            model.addAttribute("usuario", p1);
        }
        return "/usuarios/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraUsuario(AlteraUsuarios usuarios)
    {
        Usuario p1 = repository.getReferenceById(usuarios.id());
        p1.atualizaUsuario(usuarios);
        repository.save(p1);
        return "redirect:/usuarios/lista";
    }

    @DeleteMapping("/excluir")
    @Transactional
    public String removeUsuario(Long id)
    {
        repository.deleteById(id);
        return "redirect:/usuarios/lista";
    }
}

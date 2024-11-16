package com.projetoFinal.Projeto.Final.model.fichas;

import com.projetoFinal.Projeto.Final.model.produtos.Produto;
import com.projetoFinal.Projeto.Final.model.usuarios.Usuario;

public record CadastroFicha(
        Produto produto,
        Usuario usuario,
        Boolean apresentaDoencaCardiovascular,
        Boolean hipertensaoArterial,
        Boolean hipotensaoArterial,
        Boolean arritmia,
        Boolean apresentaAlgumaAlteracaoSistemaNervoso,
        Boolean dorDeCabeca,
        Boolean fraquezaMuscular,
        Boolean tremedeira,
        Boolean tremorMuscular,
        Boolean visaoTurva,
        Boolean agitacao,
        Boolean vertigens,
        Boolean formigamentoEmMMSS,
        Boolean incoordenacaoMotora
) {}


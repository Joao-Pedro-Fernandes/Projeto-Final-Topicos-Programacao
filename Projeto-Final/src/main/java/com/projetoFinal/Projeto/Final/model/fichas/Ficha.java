package com.projetoFinal.Projeto.Final.model.fichas;

import com.projetoFinal.Projeto.Final.model.produtos.Produto;
import com.projetoFinal.Projeto.Final.model.usuarios.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name="Fichas")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private Boolean apresentaDoencaCardiovascular;
    private Boolean hipertensaoArterial;
    private Boolean hipotensaoArterial;
    private Boolean arritmia;
    private Boolean apresentaAlgumaAlteracaoSistemaNervoso;
    private Boolean dorDeCabeca;
    private Boolean fraquezaMuscular;
    private Boolean tremedeira;
    private Boolean tremorMuscular;
    private Boolean visaoTurva;
    private Boolean agitacao;
    private Boolean vertigens;
    private Boolean formigamentoEmMMSS;
    private Boolean incoordenacaoMotora;

    public Ficha(){}

    public Ficha(CadastroFicha ficha) {
        this.produto = ficha.produto();
        this.usuario = ficha.usuario();
        this.apresentaDoencaCardiovascular = ficha.apresentaDoencaCardiovascular();
        this.hipertensaoArterial = ficha.hipertensaoArterial();
        this.hipotensaoArterial = ficha.hipotensaoArterial();
        this.arritmia = ficha.arritmia();
        this.apresentaAlgumaAlteracaoSistemaNervoso = ficha.apresentaAlgumaAlteracaoSistemaNervoso();
        this.dorDeCabeca = ficha.dorDeCabeca();
        this.fraquezaMuscular = ficha.fraquezaMuscular();
        this.tremedeira = ficha.tremedeira();
        this.tremorMuscular = ficha.tremorMuscular();
        this.visaoTurva = ficha.visaoTurva();
        this.agitacao = ficha.agitacao();
        this.vertigens = ficha.vertigens();
        this.formigamentoEmMMSS = ficha.formigamentoEmMMSS();
        this.incoordenacaoMotora = ficha.incoordenacaoMotora();
    }


    public void atualizaFicha(AlteraFichas ficha)
    {
        this.produto = ficha.produto();
        this.usuario = ficha.usuario();
        this.apresentaDoencaCardiovascular = ficha.apresentaDoencaCardiovascular();
        this.hipertensaoArterial = ficha.hipertensaoArterial();
        this.hipotensaoArterial = ficha.hipotensaoArterial();
        this.arritmia = ficha.arritmia();
        this.apresentaAlgumaAlteracaoSistemaNervoso = ficha.apresentaAlgumaAlteracaoSistemaNervoso();
        this.dorDeCabeca = ficha.dorDeCabeca();
        this.fraquezaMuscular = ficha.fraquezaMuscular();
        this.tremedeira = ficha.tremedeira();
        this.tremorMuscular = ficha.tremorMuscular();
        this.visaoTurva = ficha.visaoTurva();
        this.agitacao = ficha.agitacao();
        this.vertigens = ficha.vertigens();
        this.formigamentoEmMMSS = ficha.formigamentoEmMMSS();
        this.incoordenacaoMotora = ficha.incoordenacaoMotora();
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean getApresentaDoencaCardiovascular() {
        return apresentaDoencaCardiovascular;
    }

    public Boolean getHipertensaoArterial() {
        return hipertensaoArterial;
    }

    public Boolean getHipotensaoArterial() {
        return hipotensaoArterial;
    }

    public Boolean getArritmia() {
        return arritmia;
    }

    public Boolean getApresentaAlgumaAlteracaoSistemaNervoso() {
        return apresentaAlgumaAlteracaoSistemaNervoso;
    }

    public Boolean getDorDeCabeca() {
        return dorDeCabeca;
    }

    public Boolean getFraquezaMuscular() {
        return fraquezaMuscular;
    }

    public Boolean getTremedeira() {
        return tremedeira;
    }

    public Boolean getTremorMuscular() {
        return tremorMuscular;
    }

    public Boolean getVisaoTurva() {
        return visaoTurva;
    }

    public Boolean getAgitacao() {
        return agitacao;
    }

    public Boolean getVertigens() {
        return vertigens;
    }

    public Boolean getFormigamentoEmMMSS() {
        return formigamentoEmMMSS;
    }

    public Boolean getIncoordenacaoMotora() {
        return incoordenacaoMotora;
    }
}

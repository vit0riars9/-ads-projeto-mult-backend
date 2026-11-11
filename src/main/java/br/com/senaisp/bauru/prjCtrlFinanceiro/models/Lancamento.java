package br.com.senaisp.bauru.prjCtrlFinanceiro.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamentos")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	    
	@Column(nullable = false)
	private String descricao;

	private BigDecimal valor;
    //Indicará no banco de dados que a coluna vai se chamar data_lancamento
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    private String observacao;
    //Indicará no banco de dados que a coluna vai se chamar categoria_id e irá relacionar-se com a tabela de categorias
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //Indicará no banco de dados que a coluna vai se chamar usuario_id e irá relacionar-se com a tabela de usuarios
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    //constructor
    public Lancamento() {}
    
    public Lancamento(Long id, String descricao, BigDecimal valor, LocalDate dataLancamento, String observacao, Categoria categoria, Usuario usuario) {
    		this.id = id;
            this.descricao = descricao;
            this.valor = valor;
            this.dataLancamento = dataLancamento;
            this.observacao = observacao;
            this.categoria = categoria;
            this.usuario = usuario;
            
    }
    
    //Getters e Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}


package mercadolivre.model;

public class Produto {
	private Long id;
	private String nome;
	private Double preco;
	private String descricao;
	private Especificacoes specs;

	public Produto() {
	}

	public Produto(Long id, String nome, Double preco, String descricao, Especificacoes specs) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.specs = specs;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Especificacoes getSpecs() {
		return specs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setSpecs(Especificacoes specs) {
		this.specs = specs;
	}
}

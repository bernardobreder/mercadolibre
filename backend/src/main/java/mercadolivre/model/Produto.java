package mercadolivre.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Produto {

	@NotNull(message = "O ID não pode ser nulo")
	private Long id;

	@NotBlank(message = "O nome não pode estar em branco")
	private String nome;

	@NotNull(message = "O preço é obrigatório")
	@Positive(message = "O preço deve ser maior que zero")
	private Double preco;

	@NotBlank(message = "A descrição não pode estar em branco")
	private String descricao;

	@NotNull(message = "As especificações são obrigatórias")
	@Valid
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

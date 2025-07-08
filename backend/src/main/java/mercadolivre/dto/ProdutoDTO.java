package mercadolivre.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mercadolivre.model.Produto;

public class ProdutoDTO {

	@Schema(description = "Identificador único do produto", example = "1")
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Schema(description = "Nome do produto", example = "Samsung Galaxy A55")
	private String nome;

	@NotNull(message = "Preço é obrigatório")
	@Positive(message = "Preço deve ser maior que zero")
	@Schema(description = "Preço do produto", example = "1499.90")
	private Double preco;

	@NotBlank(message = "Descrição é obrigatória")
	@Schema(description = "Descrição detalhada do produto", example = "Smartphone moderno com câmera de 50MP e 256GB de armazenamento")
	private String descricao;

	@NotNull(message = "Especificações são obrigatórias")
	@Valid
	@Schema(description = "Especificações técnicas do produto")
	private EspecificacoesDTO specs;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, Double preco, String descricao, EspecificacoesDTO specs) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.specs = specs;
	}

	public Produto toEntity(Long id) {
		return new Produto(id, //
				this.nome, //
				this.preco, //
				this.descricao, //
				specs.toEntity());
	}

	public static ProdutoDTO fromEntity(Produto produto) {
		if (produto == null)
			return null;
		return new ProdutoDTO(produto.getId(), //
				produto.getNome(), //
				produto.getPreco(), //
				produto.getDescricao(), //
				EspecificacoesDTO.fromEntity(produto.getSpecs()));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EspecificacoesDTO getSpecs() {
		return specs;
	}

	public void setSpecs(EspecificacoesDTO specs) {
		this.specs = specs;
	}
}
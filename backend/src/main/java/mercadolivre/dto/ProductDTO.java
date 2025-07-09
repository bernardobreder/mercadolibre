package mercadolivre.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mercadolivre.model.Product;

public class ProductDTO {

	@Schema(description = "Unique identifier of the product", example = "1")
	private Long id;

	@NotBlank(message = "Product name is required")
	@Schema(description = "Name of the product", example = "Samsung Galaxy A55")
	private String name;

	@NotNull(message = "Product price is required")
	@Positive(message = "Price must be greater than zero")
	@Schema(description = "Price of the product", example = "1499.90")
	private Double price;

	@NotBlank(message = "Product description is required")
	@Schema(description = "Detailed description of the product", example = "Modern smartphone with 50MP camera and 256GB of storage")
	private String description;

	@NotNull(message = "Product specifications are required")
	@Valid
	@Schema(description = "Technical specifications of the product")
	private ProductDescDTO specs;

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price, String description, ProductDescDTO specs) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.specs = specs;
	}

	public Product toEntity(Long id) {
		return new Product(id, //
				this.name, //
				this.price, //
				this.description, //
				specs.toEntity());
	}

	public static ProductDTO fromEntity(Product produto) {
		if (produto == null)
			return null;
		return new ProductDTO(produto.getId(), //
				produto.getName(), //
				produto.getPrice(), //
				produto.getDescription(), //
				ProductDescDTO.fromEntity(produto.getSpecs()));
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double preco) {
		this.price = preco;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descricao) {
		this.description = descricao;
	}

	public ProductDescDTO getSpecs() {
		return specs;
	}

	public void setSpecs(ProductDescDTO specs) {
		this.specs = specs;
	}
}
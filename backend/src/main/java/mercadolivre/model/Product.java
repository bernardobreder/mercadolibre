package mercadolivre.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {

	@NotNull(message = "ID cannot be null")
	private Long id;

	@NotBlank(message = "Name cannot be blank")
	private String name;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be greater than zero")
	private Double price;

	@NotBlank(message = "Description cannot be blank")
	private String description;

	@NotNull(message = "Specifications are required")
	@Valid
	private ProductDesc specs;

	public Product() {
	}

	public Product(Long id, String name, Double price, String description, ProductDesc specs) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.specs = specs;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public ProductDesc getSpecs() {
		return specs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public void setPrice(Double preco) {
		this.price = preco;
	}

	public void setDescription(String descricao) {
		this.description = descricao;
	}

	public void setSpecs(ProductDesc specs) {
		this.specs = specs;
	}
}

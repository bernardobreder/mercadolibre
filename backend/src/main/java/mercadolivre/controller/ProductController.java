package mercadolivre.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import mercadolivre.dto.ProductDTO;
import mercadolivre.model.Product;
import mercadolivre.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@Operation(summary = "List all available products")
	@GetMapping
	public List<Product> list() {
		return service.listarTodos();
	}

	@Operation(summary = "Search for a product by ID")
	@GetMapping("/{id}")
	public Product searchById(@PathVariable Long id) {
		return service.searchById(id);
	}

	@PostMapping("")
	public ResponseEntity<?> create(@Valid @RequestBody ProductDTO dto) {
		var product = service.salvar(dto);
		return ResponseEntity.status(HttpStatus.CREATED) //
				.body(ProductDTO.fromEntity(product));
	}

}

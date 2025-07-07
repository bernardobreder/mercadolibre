package mercadolivre.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import mercadolivre.model.Produto;
import mercadolivre.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProdutoController {

	private final ProdutoService service;

	public ProdutoController(ProdutoService service) {
		this.service = service;
	}

	@Operation(summary = "Lista todos os produtos disponíveis")
	@GetMapping
	public List<Produto> listar() {
		return service.listarTodos();
	}

	@Operation(summary = "Busca um produto pelo ID")
	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

}

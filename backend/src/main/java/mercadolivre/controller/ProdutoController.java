package mercadolivre.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadolivre.model.Especificacoes;
import mercadolivre.model.Produto;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProdutoController {

	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable Long id) {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);

		return new Produto(id, "Samsung Galaxy A55", 439.0, "O Samsung A55 é rápido, moderno e bonito.", specs);
	}
}

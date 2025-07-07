package mercadolivre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mercadolivre.model.Produto;
import mercadolivre.repository.ProductRepository;

@Service
public class ProdutoService {

	private final ProductRepository repository;

	public ProdutoService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Produto> listarTodos() {
		return repository.findAll();
	}

	public Produto buscarPorId(Long id) {
		return repository.findById(id);
	}
}

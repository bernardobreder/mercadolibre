package mercadolivre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.Produto;
import mercadolivre.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;

	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}

	public List<Produto> listarTodos() {
		return repository.findAll();
	}

	public Produto buscarPorId(Long id) {
		Produto produto = repository.findById(id);
		if (produto == null) {
			throw new ProdutoNotFoundException("Produto não encontrado");
		}
		return produto;
	}

}

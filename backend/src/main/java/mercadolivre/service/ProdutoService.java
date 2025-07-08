package mercadolivre.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mercadolivre.dto.ProdutoDTO;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.Produto;
import mercadolivre.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

	private final ProdutoRepository repository;

	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}

	public List<Produto> listarTodos() {
		logger.info("Listando todos os produtos");
		List<Produto> produtos = repository.findAll();
		logger.debug("Total de produtos encontrados: {}", produtos.size());
		return produtos;
	}

	public Produto buscarPorId(Long id) {
		logger.info("Buscando produto com ID {}", id);
		Produto produto = repository.findById(id);
		if (produto == null) {
			logger.warn("Produto com ID {} não encontrado", id);
			throw new ProdutoNotFoundException("Produto não encontrado");
		}
		logger.info("Produto encontrado: {}", produto.getNome());
		return produto;
	}

	public Produto salvar(ProdutoDTO dto) {
		logger.info("Salvando novo produto com dados: nome={}, preco={}", dto.getNome(), dto.getPreco());
		Long novoId = repository.getNextId();
		Produto produto = dto.toEntity(novoId);
		repository.save(produto);
		logger.info("Produto salvo com sucesso. ID gerado: {}", produto.getId());
		return produto;
	}

}
package mercadolivre.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mercadolivre.dto.ProductDTO;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.Product;
import mercadolivre.repository.ProductRepository;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Product> listarTodos() {
		logger.info("Listing all products");
		List<Product> produtos = repository.findAll();
		logger.debug("Total products found: {}", produtos.size());
		return produtos;
	}

	public Product searchById(Long id) {
		logger.info("Searching for product with ID {}", id);
		Product produto = repository.findById(id);
		if (produto == null) {
			logger.warn("Product with ID {} not found", id);
			throw new ProdutoNotFoundException("Product not found");
		}
		logger.info("Product found: {}", produto.getName());
		return produto;
	}

	public Product salvar(ProductDTO dto) {
		logger.info("Saving new product with data: name={}, price={}", dto.getName(), dto.getPrice());
		Long novoId = repository.getNextId();
		Product produto = dto.toEntity(novoId);
		repository.save(produto);
		logger.info("Product successfully saved. Generated ID: {}", produto.getId());
		return produto;
	}

}
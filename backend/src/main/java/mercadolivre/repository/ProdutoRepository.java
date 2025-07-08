package mercadolivre.repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mercadolivre.model.Produto;

@Repository
public class ProdutoRepository {

	private final List<Produto> produtos;
	private final AtomicLong sequence = new AtomicLong(1l);

	public ProdutoRepository() {
		var mapper = new ObjectMapper();
		try (var is = getClass().getResourceAsStream("/products.json")) {
			this.produtos = mapper.readValue(is, new TypeReference<List<Produto>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar produtos.json", e);
		}
	}

	public synchronized Long getNextId() {
		return sequence.getAndIncrement();
	}

	public void save(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Produto> findAll() {
		return produtos;
	}

	public Produto findById(Long id) {
		return produtos.stream() //
				.filter(p -> p.getId().equals(id)) //
				.findFirst() //
				.orElse(null);
	}
}

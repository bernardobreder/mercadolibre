package mercadolivre.repository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mercadolivre.model.Product;

@Repository
public class ProductRepository {

	private final List<Product> products;
	private final AtomicLong sequence = new AtomicLong(1l);

	public ProductRepository() {
		var mapper = new ObjectMapper();
		try (var in = getClass().getResourceAsStream("/products.json")) {
			this.products = mapper.readValue(in, new TypeReference<>() {
			});
		} catch (IOException e) {
			throw new RuntimeException("Error with products.json", e);
		}
	}

	public synchronized Long getNextId() {
		return sequence.getAndIncrement();
	}

	public void save(Product produto) {
		this.products.add(produto);
	}

	public List<Product> findAll() {
		return products;
	}

	public Product findById(Long id) {
		return products.stream() //
				.filter(p -> p.getId().equals(id)) //
				.findFirst() //
				.orElse(null);
	}
}

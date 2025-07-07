package mercadolivre.repository;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mercadolivre.model.Produto;

@Repository
public class ProdutoRepository {

	private final List<Produto> produtos;

	public ProdutoRepository() {
		ObjectMapper mapper = new ObjectMapper();
		try (InputStream is = getClass().getResourceAsStream("/products.json")) {
			this.produtos = mapper.readValue(is, new TypeReference<List<Produto>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar produtos.json", e);
		}
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

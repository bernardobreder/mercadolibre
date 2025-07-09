package mercadolivre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mercadolivre.dto.ProductDescDTO;
import mercadolivre.dto.ProductDTO;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.ProductDesc;
import mercadolivre.model.Product;
import mercadolivre.repository.ProductRepository;
import mercadolivre.service.ProductService;

public class ProdutoServiceTest {

	private ProductRepository repository;
	private ProductService service;

	@BeforeEach
	public void setup() {
		repository = mock(ProductRepository.class);
		service = new ProductService(repository);
	}

	@Test
	public void deveListarProdutos() {
		when(repository.findAll()).thenReturn(List.of(new Product(1L, "Produto Teste", 100.0, "Desc", new ProductDesc())));

		List<Product> lista = service.listarTodos();

		assertFalse(lista.isEmpty());
		assertEquals("Produto Teste", lista.get(0).getName());
	}

	@Test
	public void deveBuscarPorIdComSucesso() {
		Product p = new Product(1L, "Teste", 200.0, "Desc", new ProductDesc());
		when(repository.findById(1L)).thenReturn(p);

		Product result = service.searchById(1L);

		assertNotNull(result);
		assertEquals(1L, result.getId());
	}

	@Test
	public void deveLancarExcecaoSeNaoEncontrarProduto() {
		when(repository.findById(99L)).thenReturn(null);

		assertThrows(ProdutoNotFoundException.class, () -> {
			service.searchById(99L);
		});
	}

	@Test
	void deveSalvarProdutoComSucesso() {
		ProductDTO dto = new ProductDTO();
		dto.setName("Galaxy A55");
		dto.setPrice(1999.99);
		dto.setDescription("Celular moderno");
		ProductDescDTO specs = new ProductDescDTO();
		specs.setScreenSize("6.6\"");
		specs.setStorage("256 GB");
		specs.setMainCamera("50 MP");
		specs.setFrontCamera("32 MP");
		specs.setNfc(true);
		dto.setSpecs(specs);

		dto.toEntity(1L);

		when(repository.getNextId()).thenReturn(1L);

		// Act
		Product salvo = service.salvar(dto);

		// Assert
		verify(repository).save(salvo);
		assertEquals("Galaxy A55", salvo.getName());
		assertEquals(1999.99, salvo.getPrice());
		assertEquals("256 GB", salvo.getSpecs().getStorage());
	}

}

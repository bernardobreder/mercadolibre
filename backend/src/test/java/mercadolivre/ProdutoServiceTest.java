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

import mercadolivre.dto.EspecificacoesDTO;
import mercadolivre.dto.ProdutoDTO;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.Especificacoes;
import mercadolivre.model.Produto;
import mercadolivre.repository.ProdutoRepository;
import mercadolivre.service.ProdutoService;

public class ProdutoServiceTest {

	private ProdutoRepository repository;
	private ProdutoService service;

	@BeforeEach
	public void setup() {
		repository = mock(ProdutoRepository.class);
		service = new ProdutoService(repository);
	}

	@Test
	public void deveListarProdutos() {
		when(repository.findAll()).thenReturn(List.of(new Produto(1L, "Produto Teste", 100.0, "Desc", new Especificacoes())));

		List<Produto> lista = service.listarTodos();

		assertFalse(lista.isEmpty());
		assertEquals("Produto Teste", lista.get(0).getNome());
	}

	@Test
	public void deveBuscarPorIdComSucesso() {
		Produto p = new Produto(1L, "Teste", 200.0, "Desc", new Especificacoes());
		when(repository.findById(1L)).thenReturn(p);

		Produto result = service.buscarPorId(1L);

		assertNotNull(result);
		assertEquals(1L, result.getId());
	}

	@Test
	public void deveLancarExcecaoSeNaoEncontrarProduto() {
		when(repository.findById(99L)).thenReturn(null);

		assertThrows(ProdutoNotFoundException.class, () -> {
			service.buscarPorId(99L);
		});
	}

	@Test
	void deveSalvarProdutoComSucesso() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setNome("Galaxy A55");
		dto.setPreco(1999.99);
		dto.setDescricao("Celular moderno");
		EspecificacoesDTO specs = new EspecificacoesDTO();
		specs.setTela("6.6\"");
		specs.setMemoria("256 GB");
		specs.setCameraPrincipal("50 MP");
		specs.setFrontal("32 MP");
		specs.setNfc(true);
		dto.setSpecs(specs);

		dto.toEntity(1L);

		when(repository.getNextId()).thenReturn(1L);

		// Act
		Produto salvo = service.salvar(dto);

		// Assert
		verify(repository).save(salvo);
		assertEquals("Galaxy A55", salvo.getNome());
		assertEquals(1999.99, salvo.getPreco());
		assertEquals("256 GB", salvo.getSpecs().getMemoria());
	}

}

package mercadolivre;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mercadolivre.controller.ProdutoController;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.Especificacoes;
import mercadolivre.model.Produto;
import mercadolivre.service.ProdutoService;

@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProdutoService produtoService;

	@Test
	void deveRetornarListaDeProdutos() throws Exception {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Produto produto = new Produto(1L, "Samsung Galaxy A55", 1499.90, "Smartphone moderno e rápido", specs);

		Mockito.when(produtoService.listarTodos()).thenReturn(List.of(produto));

		mockMvc.perform(get("/api/produtos").accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$[0].nome").value("Samsung Galaxy A55")) //
				.andExpect(jsonPath("$[0].specs.tela").value("6.6\"")) //
				.andExpect(jsonPath("$[0].specs.memoria").value("256 GB")) //
				.andExpect(jsonPath("$[0].specs.cameraPrincipal").value("50 MP")) //
				.andExpect(jsonPath("$[0].specs.frontal").value("32 MP")) //
				.andExpect(jsonPath("$[0].specs.nfc").value(true));
	}

	@Test
	void deveRetornarProdutoPorId() throws Exception {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Produto produto = new Produto(1L, "Samsung Galaxy A55", 1499.90, "Smartphone moderno e rápido", specs);

		Mockito.when(produtoService.buscarPorId(1L)).thenReturn(produto);

		mockMvc.perform(get("/api/produtos/1").accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.nome").value("Samsung Galaxy A55")) //
				.andExpect(jsonPath("$.specs.tela").value("6.6\"")) //
				.andExpect(jsonPath("$.specs.nfc").value(true));
	}

	@Test
	public void deveRetornar404QuandoProdutoNaoEncontrado() throws Exception {
		when(produtoService.buscarPorId(99L)).thenThrow(new ProdutoNotFoundException("Produto não encontrado"));

		mockMvc.perform(get("/produtos/99")) //
				.andExpect(status().isNotFound()) //
				.andExpect(content().string("Produto não encontrado"));
	}

}
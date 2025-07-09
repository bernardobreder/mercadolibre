package mercadolivre;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import mercadolivre.controller.ProductController;
import mercadolivre.dto.ProductDescDTO;
import mercadolivre.dto.ProductDTO;
import mercadolivre.exception.GlobalExceptionHandler.ProdutoNotFoundException;
import mercadolivre.model.ProductDesc;
import mercadolivre.model.Product;
import mercadolivre.service.ProductService;

@WebMvcTest(controllers = ProductController.class)
public class ProdutoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService produtoService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void deveRetornarListaDeProdutos() throws Exception {
		ProductDesc specs = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Product produto = new Product(1L, "Samsung Galaxy A55", 1499.90, "Smartphone moderno e rápido", specs);

		Mockito.when(produtoService.listarTodos()).thenReturn(List.of(produto));

		mockMvc.perform(get("/api/products").accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$[0].name").value("Samsung Galaxy A55")) //
				.andExpect(jsonPath("$[0].specs.screenSize").value("6.6\"")) //
				.andExpect(jsonPath("$[0].specs.storage").value("256 GB")) //
				.andExpect(jsonPath("$[0].specs.mainCamera").value("50 MP")) //
				.andExpect(jsonPath("$[0].specs.frontCamera").value("32 MP")) //
				.andExpect(jsonPath("$[0].specs.nfc").value(true));
	}

	@Test
	void deveRetornarProdutoPorId() throws Exception {
		ProductDesc specs = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Product produto = new Product(1L, "Samsung Galaxy A55", 1499.90, "Smartphone moderno e rápido", specs);

		Mockito.when(produtoService.searchById(1L)).thenReturn(produto);

		mockMvc.perform(get("/api/products/1").accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.name").value("Samsung Galaxy A55")) //
				.andExpect(jsonPath("$.specs.screenSize").value("6.6\"")) //
				.andExpect(jsonPath("$.specs.nfc").value(true));
	}

	@Test
	public void deveRetornar404QuandoProdutoNaoEncontrado() throws Exception {
		when(produtoService.searchById(99L)).thenThrow(new ProdutoNotFoundException("Produto não encontrado"));

		mockMvc.perform(get("/api/products/99")) //
				.andExpect(status().isNotFound()) //
				.andExpect(content().string("Produto não encontrado"));
	}

	@Test
	public void deveSalvarProdutoComSucesso() throws Exception {
		var dto = new ProductDTO();
		dto.setName("Galaxy A55");
		dto.setPrice(1999.99);
		dto.setDescription("Celular moderno");

		var specs = new ProductDescDTO();
		specs.setScreenSize("6.6\"");
		specs.setStorage("256 GB");
		specs.setMainCamera("50 MP");
		specs.setFrontCamera("32 MP");
		specs.setNfc(true);
		dto.setSpecs(specs);

		var entity = dto.toEntity(1L);
		when(produtoService.salvar(any())).thenReturn(entity);

		mockMvc.perform(post("/api/products") //
				.contentType(MediaType.APPLICATION_JSON) //
				.content(objectMapper.writeValueAsString(dto))) //
				.andExpect(status().isCreated());

		verify(produtoService).salvar(any());
	}

}
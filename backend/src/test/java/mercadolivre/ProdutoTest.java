package mercadolivre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import mercadolivre.model.ProductDesc;
import mercadolivre.model.Product;

public class ProdutoTest {

	@Test
	public void deveCriarProdutoComEspecificacoes() {
		ProductDesc specs = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Product produto = new Product(1L, "Samsung Galaxy A55", 439.0, "O Samsung A55 é rápido", specs);

		assertEquals(1L, produto.getId());
		assertEquals("Samsung Galaxy A55", produto.getName());
		assertEquals(439.0, produto.getPrice());
		assertEquals("O Samsung A55 é rápido", produto.getDescription());

		assertEquals("6.6\"", produto.getSpecs().getScreenSize());
		assertTrue(produto.getSpecs().isNfc());
	}

	@Test
	public void devePermitirAlterarCampos() {
		Product produto = new Product();
		produto.setId(2L);
		produto.setName("iPhone 15");
		produto.setPrice(999.0);
		produto.setDescription("iPhone com Dynamic Island");

		ProductDesc specs = new ProductDesc();
		specs.setStorage("512 GB");

		produto.setSpecs(specs);

		assertEquals("512 GB", produto.getSpecs().getStorage());
	}

}

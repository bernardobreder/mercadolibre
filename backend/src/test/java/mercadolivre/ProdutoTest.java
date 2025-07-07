package mercadolivre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import mercadolivre.model.Especificacoes;
import mercadolivre.model.Produto;

public class ProdutoTest {

	@Test
	public void deveCriarProdutoComEspecificacoes() {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Produto produto = new Produto(1L, "Samsung Galaxy A55", 439.0, "O Samsung A55 é rápido", specs);

		assertEquals(1L, produto.getId());
		assertEquals("Samsung Galaxy A55", produto.getNome());
		assertEquals(439.0, produto.getPreco());
		assertEquals("O Samsung A55 é rápido", produto.getDescricao());

		assertEquals("6.6\"", produto.getSpecs().getTela());
		assertTrue(produto.getSpecs().isNfc());
	}

	@Test
	public void devePermitirAlterarCampos() {
		Produto produto = new Produto();
		produto.setId(2L);
		produto.setNome("iPhone 15");
		produto.setPreco(999.0);
		produto.setDescricao("iPhone com Dynamic Island");

		Especificacoes specs = new Especificacoes();
		specs.setMemoria("512 GB");

		produto.setSpecs(specs);

		assertEquals("512 GB", produto.getSpecs().getMemoria());
	}

}

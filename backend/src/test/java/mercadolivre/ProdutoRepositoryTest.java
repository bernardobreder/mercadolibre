package mercadolivre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import mercadolivre.model.Product;
import mercadolivre.repository.ProductRepository;

class ProdutoRepositoryTest {

    @Test
    void deveCarregarTodosProdutosDoJson() {
        var repository = new ProductRepository();
        var produtos = repository.findAll();

        assertFalse(produtos.isEmpty());
        assertNotNull(produtos.get(0).getName());
    }

    @Test
    void deveEncontrarProdutoPorId() {
        var repository = new ProductRepository();
        var produto = repository.findById(1L);

        assertNotNull(produto);
        assertEquals(1L, produto.getId());
    }

    @Test
    void deveRetornarNullSeProdutoNaoExistir() {
        var repository = new ProductRepository();
        var produto = repository.findById(999L);

        assertNull(produto);
    }
}
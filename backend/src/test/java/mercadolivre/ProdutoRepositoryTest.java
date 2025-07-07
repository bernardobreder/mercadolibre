package mercadolivre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import mercadolivre.model.Produto;
import mercadolivre.repository.ProdutoRepository;

class ProdutoRepositoryTest {

    @Test
    void deveCarregarTodosProdutosDoJson() {
        ProdutoRepository repository = new ProdutoRepository();
        List<Produto> produtos = repository.findAll();

        assertFalse(produtos.isEmpty());
        assertNotNull(produtos.get(0).getNome());
    }

    @Test
    void deveEncontrarProdutoPorId() {
        ProdutoRepository repository = new ProdutoRepository();
        Produto produto = repository.findById(1L);

        assertNotNull(produto);
        assertEquals(1L, produto.getId());
    }

    @Test
    void deveRetornarNullSeProdutoNaoExistir() {
        ProdutoRepository repository = new ProdutoRepository();
        Produto produto = repository.findById(999L);

        assertNull(produto);
    }
}
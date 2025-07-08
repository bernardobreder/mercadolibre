package mercadolivre;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import mercadolivre.dto.EspecificacoesDTO;
import mercadolivre.dto.ProdutoDTO;
import mercadolivre.model.Especificacoes;
import mercadolivre.model.Produto;
import static org.junit.jupiter.api.Assertions.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class)
public class ProdutoDTOTest {

	@Test
	void deveConverterParaEntidade() {
		EspecificacoesDTO specsDTO = new EspecificacoesDTO("6.6\"", "256 GB", "50 MP", "32 MP", true);
		ProdutoDTO dto = new ProdutoDTO(1L, "Galaxy", 1999.99, "Smartphone", specsDTO);

		Produto produto = dto.toEntity(1L);

		assertEquals("Galaxy", produto.getNome());
		assertEquals("256 GB", produto.getSpecs().getMemoria());
		assertTrue(produto.getSpecs().isNfc());
	}

	@Test
	void deveConverterParaDTO() {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Produto produto = new Produto(1L, "Galaxy", 1999.99, "Smartphone", specs);

		ProdutoDTO dto = ProdutoDTO.fromEntity(produto);

		assertEquals("Galaxy", dto.getNome());
		assertEquals("256 GB", dto.getSpecs().getMemoria());
		assertTrue(dto.getSpecs().getNfc());
	}

	@Test
	void deveDetectarViolacoesDeValidacao() {
		ProdutoDTO dto = new ProdutoDTO(); // campos nulos

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<ProdutoDTO>> violacoes = validator.validate(dto);

		assertFalse(violacoes.isEmpty());
		assertTrue(violacoes.stream().anyMatch(v -> v.getPropertyPath().toString().equals("nome")));
		assertTrue(violacoes.stream().anyMatch(v -> v.getPropertyPath().toString().equals("preco")));
	}

	@Test
	void deveConverterEspecificacoesDTOParaEntidade() {
		EspecificacoesDTO dto = new EspecificacoesDTO("6.6\"", "256 GB", "50 MP", "32 MP", true);

		Especificacoes entity = dto.toEntity();

		assertEquals("256 GB", entity.getMemoria());
	}

	@Test
	void deveConverterEntidadeParaEspecificacoesDTO() {
		Especificacoes entity = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);

		EspecificacoesDTO dto = EspecificacoesDTO.fromEntity(entity);

		assertEquals("50 MP", dto.getCameraPrincipal());
	}

	@Test
	void dto_FromEntity_and_ToEntity_Mapping() {
		Especificacoes specs = new Especificacoes("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Produto produto = new Produto(1L, "Galaxy", 1999.99, "Smartphone", specs);
		ProdutoDTO dto = ProdutoDTO.fromEntity(produto);
		Produto converted = dto.toEntity(produto.getId());
		assertEquals(produto.getNome(), converted.getNome());
	}

}

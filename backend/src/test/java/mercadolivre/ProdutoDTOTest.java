package mercadolivre;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import mercadolivre.dto.ProductDescDTO;
import mercadolivre.dto.ProductDTO;
import mercadolivre.model.ProductDesc;
import mercadolivre.model.Product;
import static org.junit.jupiter.api.Assertions.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class)
public class ProdutoDTOTest {

	@Test
	void deveConverterParaEntidade() {
		ProductDescDTO specsDTO = new ProductDescDTO("6.6\"", "256 GB", "50 MP", "32 MP", true);
		ProductDTO dto = new ProductDTO(1L, "Galaxy", 1999.99, "Smartphone", specsDTO);

		Product produto = dto.toEntity(1L);

		assertEquals("Galaxy", produto.getName());
		assertEquals("256 GB", produto.getSpecs().getStorage());
		assertTrue(produto.getSpecs().isNfc());
	}

	@Test
	void deveConverterParaDTO() {
		ProductDesc specs = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Product produto = new Product(1L, "Galaxy", 1999.99, "Smartphone", specs);

		ProductDTO dto = ProductDTO.fromEntity(produto);

		assertEquals("Galaxy", dto.getName());
		assertEquals("256 GB", dto.getSpecs().getStorage());
		assertTrue(dto.getSpecs().getNfc());
	}

	@Test
	void deveDetectarViolacoesDeValidacao() {
		ProductDTO dto = new ProductDTO(); // campos nulos

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<ProductDTO>> violacoes = validator.validate(dto);

		assertFalse(violacoes.isEmpty());
		assertTrue(violacoes.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
		assertTrue(violacoes.stream().anyMatch(v -> v.getPropertyPath().toString().equals("price")));
	}

	@Test
	void deveConverterEspecificacoesDTOParaEntidade() {
		ProductDescDTO dto = new ProductDescDTO("6.6\"", "256 GB", "50 MP", "32 MP", true);

		ProductDesc entity = dto.toEntity();

		assertEquals("256 GB", entity.getStorage());
	}

	@Test
	void deveConverterEntidadeParaEspecificacoesDTO() {
		ProductDesc entity = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);

		ProductDescDTO dto = ProductDescDTO.fromEntity(entity);

		assertEquals("50 MP", dto.getMainCamera());
	}

	@Test
	void dto_FromEntity_and_ToEntity_Mapping() {
		ProductDesc specs = new ProductDesc("6.6\"", "256 GB", "50 MP", "32 MP", true);
		Product produto = new Product(1L, "Galaxy", 1999.99, "Smartphone", specs);
		ProductDTO dto = ProductDTO.fromEntity(produto);
		Product converted = dto.toEntity(produto.getId());
		assertEquals(produto.getName(), converted.getName());
	}

}

package mercadolivre.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mercadolivre.model.ProductDesc;

public class ProductDescDTO {

	@Schema(description = "Product screen size", example = "6.6\"")
	@NotBlank(message = "Screen information is required")
	private String screenSize;

	@Schema(description = "Internal storage of the product", example = "256 GB")
	@NotBlank(message = "Internal memory is required")
	private String storage;

	@Schema(description = "Resolution of the main camera", example = "50 MP")
	@NotBlank(message = "Main camera information is required")
	private String mainCamera;

	@Schema(description = "Resolution of the front camera", example = "32 MP")
	@NotBlank(message = "Front camera information is required")
	private String frontCamera;

	@Schema(description = "Indicates whether the product supports NFC", example = "true")
	@NotNull(message = "NFC information is required")
	private Boolean nfc;

	public ProductDescDTO() {
	}

	public ProductDescDTO(String screenSize, String storage, String mainCamera, String frontCamera, boolean nfc) {
		this.screenSize = screenSize;
		this.storage = storage;
		this.mainCamera = mainCamera;
		this.frontCamera = frontCamera;
		this.nfc = nfc;
	}

	public ProductDesc toEntity() {
		return new ProductDesc(screenSize, storage, mainCamera, frontCamera, nfc);
	}

	public static ProductDescDTO fromEntity(ProductDesc entity) {
		if (entity == null)
			return null;
		return new ProductDescDTO( //
				entity.getScreenSize(), //
				entity.getStorage(), //
				entity.getMainCamera(), //
				entity.getFrontCamera(), //
				entity.isNfc());
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String tela) {
		this.screenSize = tela;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String memoria) {
		this.storage = memoria;
	}

	public String getMainCamera() {
		return mainCamera;
	}

	public void setMainCamera(String cameraPrincipal) {
		this.mainCamera = cameraPrincipal;
	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(String frontal) {
		this.frontCamera = frontal;
	}

	public Boolean getNfc() {
		return nfc;
	}

	public void setNfc(Boolean nfc) {
		this.nfc = nfc;
	}

}
package mercadolivre.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDesc {

	@NotBlank(message = "Screen size is required")
	private String screenSize;

	@NotBlank(message = "Internal storage is required")
	private String storage;

	@NotBlank(message = "Main camera resolution is required")
	private String mainCamera;

	@NotBlank(message = "Front camera resolution is required")
	private String frontCamera;

	@NotNull(message = "NFC support information is required")
	private Boolean nfc;

	public ProductDesc() {
	}

	public ProductDesc(String tela, String memoria, String cameraPrincipal, String frontal, boolean nfc) {
		this.screenSize = tela;
		this.storage = memoria;
		this.mainCamera = cameraPrincipal;
		this.frontCamera = frontal;
		this.nfc = nfc;
	}

	// Getters e Setters
	public String getScreenSize() {
		return screenSize;
	}

	public String getStorage() {
		return storage;
	}

	public String getMainCamera() {
		return mainCamera;
	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public boolean isNfc() {
		return nfc;
	}

	public void setScreenSize(String tela) {
		this.screenSize = tela;
	}

	public void setStorage(String memoria) {
		this.storage = memoria;
	}

	public void setMainCamera(String cameraPrincipal) {
		this.mainCamera = cameraPrincipal;
	}

	public void setFrontCamera(String frontal) {
		this.frontCamera = frontal;
	}

	public void setNfc(boolean nfc) {
		this.nfc = nfc;
	}
}
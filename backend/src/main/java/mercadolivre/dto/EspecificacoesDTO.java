package mercadolivre.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mercadolivre.model.Especificacoes;

public class EspecificacoesDTO {

	@Schema(description = "Tamanho da tela do produto", example = "6.6\"")
	@NotBlank(message = "A informação da tela é obrigatória")
	private String tela;

	@Schema(description = "Memória interna do produto", example = "256 GB")
	@NotBlank(message = "A memória é obrigatória")
	private String memoria;

	@Schema(description = "Resolução da câmera principal", example = "50 MP")
	@NotBlank(message = "A câmera principal é obrigatória")
	private String cameraPrincipal;

	@Schema(description = "Resolução da câmera frontal", example = "32 MP")
	@NotBlank(message = "A câmera frontal é obrigatória")
	private String frontal;

	@Schema(description = "Indica se o produto possui suporte a NFC", example = "true")
	@NotNull(message = "A informação de NFC é obrigatória")
	private Boolean nfc;

	public EspecificacoesDTO() {
	}

	public EspecificacoesDTO(String tela, String memoria, String cameraPrincipal, String frontal, boolean nfc) {
		this.tela = tela;
		this.memoria = memoria;
		this.cameraPrincipal = cameraPrincipal;
		this.frontal = frontal;
		this.nfc = nfc;
	}

	public Especificacoes toEntity() {
		return new Especificacoes(tela, memoria, cameraPrincipal, frontal, nfc);
	}

	public static EspecificacoesDTO fromEntity(Especificacoes entity) {
		if (entity == null)
			return null;
		return new EspecificacoesDTO( //
				entity.getTela(), //
				entity.getMemoria(), //
				entity.getCameraPrincipal(), //
				entity.getFrontal(), //
				entity.isNfc());
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getCameraPrincipal() {
		return cameraPrincipal;
	}

	public void setCameraPrincipal(String cameraPrincipal) {
		this.cameraPrincipal = cameraPrincipal;
	}

	public String getFrontal() {
		return frontal;
	}

	public void setFrontal(String frontal) {
		this.frontal = frontal;
	}

	public Boolean getNfc() {
		return nfc;
	}

	public void setNfc(Boolean nfc) {
		this.nfc = nfc;
	}

}
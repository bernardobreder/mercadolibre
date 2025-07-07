package mercadolivre.model;

public class Especificacoes {
	private String tela;
	private String memoria;
	private String cameraPrincipal;
	private String frontal;
	private boolean nfc;

	public Especificacoes() {
	}

	public Especificacoes(String tela, String memoria, String cameraPrincipal, String frontal, boolean nfc) {
		this.tela = tela;
		this.memoria = memoria;
		this.cameraPrincipal = cameraPrincipal;
		this.frontal = frontal;
		this.nfc = nfc;
	}

	// Getters e Setters
	public String getTela() {
		return tela;
	}

	public String getMemoria() {
		return memoria;
	}

	public String getCameraPrincipal() {
		return cameraPrincipal;
	}

	public String getFrontal() {
		return frontal;
	}

	public boolean isNfc() {
		return nfc;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public void setCameraPrincipal(String cameraPrincipal) {
		this.cameraPrincipal = cameraPrincipal;
	}

	public void setFrontal(String frontal) {
		this.frontal = frontal;
	}

	public void setNfc(boolean nfc) {
		this.nfc = nfc;
	}
}
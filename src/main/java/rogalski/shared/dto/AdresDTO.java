package rogalski.shared.dto;

public class AdresDTO {
//	@NotNull(message = "Kod pocztowy nie może być pusty.")
	private String kodPocztowy;

	private String ulica;

//	@NotNull(message = "Nr domu nie może być pusty.")
	private String nrDomu;

//	@NotNull(message = "Miejscowosc nie może być pusta.")
	private String miejscowosc;

	/////////////////////////////////

	public AdresDTO(String kodPocztowy, String ulica, String nrDomu, String miejscowosc) {
		super();
		this.kodPocztowy = kodPocztowy;
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.miejscowosc = miejscowosc;
	}

	public AdresDTO() {
		super();
	}

	/////////////////////////////////

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNrDomu() {
		return nrDomu;
	}

	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

//	public Adres stworzAdres() {
//		Adres adres = new Adres(getUlica(), getNrDomu(), getKodPocztowy(), getMiejscowosc());
//		return adres;
//	}
}

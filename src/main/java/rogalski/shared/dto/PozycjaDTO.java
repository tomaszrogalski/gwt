package rogalski.shared.dto;

import rogalski.server.model.Produkt;
import rogalski.server.model.Usluga;

public class PozycjaDTO {

	private Long id;

//	@NotNull(message = "Nazwa nie może być pusta.")
	private String nazwa;

//	@NotNull(message = "Vat nie może być pusty. ")
//	@Min(value = 0, message = "Vat musi być >0. ")
//	@Max(value = 100, message = "Vat musi być <100. ")
	private Double vat;

	private TypPozycji typ;

	private ProduktDTO produktDTO;

	private UslugaDTO uslugaDTO;

	/////////////////////////////////

	public PozycjaDTO() {
		super();
	}

	public PozycjaDTO(String nazwa, Double vat, UslugaDTO uslugaDTO) {
		super();
		this.nazwa = nazwa;
		this.vat = vat;
		this.uslugaDTO = uslugaDTO;
		this.produktDTO = new ProduktDTO(0.0, Jednostka.BRAK);
		this.typ = TypPozycji.USLUGA;
	}

	public PozycjaDTO(String nazwa, Double vat, ProduktDTO produktDTO) {
		super();
		this.nazwa = nazwa;
		this.vat = vat;
		this.produktDTO = produktDTO;
		this.uslugaDTO = new UslugaDTO(0.0);
		this.typ = TypPozycji.PRODUKT;
	}

	/////////////////////////////////

	public Long getId() {
		return id;
	}

	public TypPozycji getTyp() {
		return typ;
	}

	public void setTyp(TypPozycji typ) {
		this.typ = typ;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public ProduktDTO getProduktDTO() {
		return produktDTO;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public void setProduktDTO(ProduktDTO produktDTO) {
		this.produktDTO = produktDTO;
	}

	public UslugaDTO getUslugaDTO() {
		return uslugaDTO;
	}

	public void setUslugaDTO(UslugaDTO uslugaDTO) {
		this.uslugaDTO = uslugaDTO;
	}

	public String toStringProdukt() {
		return "Typ: " + typ + ", " + "Nazwa: " + nazwa + ", " + "VAT: " + vat + "%, " + getProduktDTO().toString();
	}

	public String toStringUsluga() {
		return "Typ: " + typ + ", " + "Nazwa: " + nazwa + ", " + "VAT: " + vat + "%, " + getUslugaDTO().toString();
	}

	@Override
	public String toString() {
		if (typ == TypPozycji.PRODUKT) {
			return toStringProdukt();
		} else if (typ == TypPozycji.USLUGA) {
			return toStringUsluga();
		} else {
			return "BLEDY, WSZEDZIE BLEDY";
		}
	}

	public Produkt stworzProdukt() {
		Produkt produkt = new Produkt(getNazwa(), getVat(), getProduktDTO().getCena(),
				getProduktDTO().getJednostka().toString());
		return produkt;
	}

	public Usluga stworzUsluge() {
		Usluga usluga = new Usluga(getNazwa(), getVat(), getUslugaDTO().getCenaZaGodzine());
		return usluga;
	}
}

package rogalski.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import rogalski.shared.dto.PozycjaDTO;
import rogalski.shared.dto.UslugaDTO;

@Entity
@DiscriminatorValue(value = "usluga")
public class Usluga extends Pozycja {

	@Column(name = "cena_za_godzine")
	private Double cenaZaGodzine;

	public Usluga() {
		super();
	}

	public Usluga(String nazwa, Double vat, Double cenaZaGodzine) {
		super(nazwa, vat);
		this.cenaZaGodzine = cenaZaGodzine;
	}

	public Usluga(String nazwa, Faktura faktura, Double vat, Double cenaZaGodzine) {
		super(nazwa, faktura, vat);
		this.cenaZaGodzine = cenaZaGodzine;
	}

	public Double getCenaZaGodzine() {
		return cenaZaGodzine;
	}

	public PozycjaDTO stworzPozycjaDTO() {

		return new PozycjaDTO(getNazwa(), getVat(), new UslugaDTO(getCenaZaGodzine()));
	}
}

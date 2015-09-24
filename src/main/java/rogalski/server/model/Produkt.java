package rogalski.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import rogalski.shared.dto.Jednostka;
import rogalski.shared.dto.PozycjaDTO;
import rogalski.shared.dto.ProduktDTO;

@Entity
@DiscriminatorValue(value = "produkt")
public class Produkt extends Pozycja {

	@Column(name = "cena")
	private Double cena;

	@Column(name = "jednostka")
	private String jednostka;

	public Produkt() {
		super();
	}

	public Produkt(String nazwa, Faktura faktura, Double vat, Double cena, String jednostka) {
		super(nazwa, faktura, vat);
		this.cena = cena;
		this.jednostka = jednostka;
	}

	public Produkt(String nazwa, Double vat, Double cena, String jednostka) {
		super(nazwa, vat);
		this.cena = cena;
		this.jednostka = jednostka;
	}

	public Double getCena() {
		return cena;
	}

	public String getJednostka() {
		return jednostka;
	}

	public PozycjaDTO stworzPozycjaDTO() {
		return new PozycjaDTO(getNazwa(), getVat(), new ProduktDTO(getCena(), Jednostka.valueOf(getJednostka())));
	}
}

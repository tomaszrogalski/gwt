package rogalski.shared.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProduktDTO {

	@NotNull(message = "Cena nie może być pusta. ")
	@Min(value = 0, message = "Cena musi być cyfra > 0. ")
	private Double cena;

	private Jednostka jednostka;

	/////////////////////////////////

	public ProduktDTO(Double cena, Jednostka jednostka) {

		this.cena = cena;
		this.jednostka = jednostka;
	}

	public ProduktDTO() {

	}

	/////////////////////////////////

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Jednostka getJednostka() {
		return jednostka;
	}

	public void setJednostka(Jednostka jednostka) {
		this.jednostka = jednostka;
	}

	@Override
	public String toString() {
		return "Cena: " + cena + "zł, Jednostka: " + jednostka.getSkrotJednostki();
	}
}

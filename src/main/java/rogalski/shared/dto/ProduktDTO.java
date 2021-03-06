package rogalski.shared.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProduktDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Cena nie moze byc pusta. ")
	@Min(value = 0, message = "Cena musi byc cyfra > 0. ")
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
		return "Cena: " + cena + "zl, Jednostka: " + jednostka.getSkrotJednostki();
	}
}

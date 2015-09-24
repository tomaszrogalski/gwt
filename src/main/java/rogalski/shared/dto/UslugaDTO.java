package rogalski.shared.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UslugaDTO {

	@NotNull(message = "Cena/h nie może być pusta. ")
	@Min(value = 0, message = "Cena/h musi być cyfra > 0. ")
	private Double cenaZaGodzine;

	/////////////////////////////////

	public UslugaDTO(Double cenaZaGodzine) {

		this.cenaZaGodzine = cenaZaGodzine;
	}

	public UslugaDTO() {
		super();
	}

	/////////////////////////////////

	public Double getCenaZaGodzine() {
		return cenaZaGodzine;
	}

	public void setCenaZaGodzine(Double cenaZaGodzine) {
		this.cenaZaGodzine = cenaZaGodzine;
	}

	@Override
	public String toString() {
		return "CenaZaGodzine: " + cenaZaGodzine + "zł/h";
	}

}

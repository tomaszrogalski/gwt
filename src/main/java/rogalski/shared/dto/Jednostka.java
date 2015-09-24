package rogalski.shared.dto;

public enum Jednostka {
	CENTYMETR("cm"), KILOGRAM("Kg"), SZTUKI("Sztuki"), LITR("l"), BRAK("-");

	private String skrotJednostki;

	private Jednostka(String skrotJednostki) {
		this.skrotJednostki = skrotJednostki;
	}

	public String getSkrotJednostki() {
		return skrotJednostki;
	}
}

package rogalski.shared.dto;

import java.io.Serializable;
import java.util.List;

import rogalski.server.model.Klient;

public class KlientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

//	@NotNull(message = "Imie nie może być puste.")
	private String imie;

//	@NotNull(message = "Nazwisko nie może być puste.")
	private String nazwisko;

	private AdresDTO adresDTO;

	private List<FakturaDTO> listaFakturDTO;

	/////////////////////////////////

	public KlientDTO(String imie, String nazwisko, AdresDTO adresDTO) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adresDTO = adresDTO;
	}

	public KlientDTO(Long id, String imie, String nazwisko, AdresDTO adresDTO) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adresDTO = adresDTO;
	}

	public KlientDTO() {
		super();
	}
	/////////////////////////////////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public AdresDTO getAdresDTO() {
		return adresDTO;
	}

	public void setAdresDTO(AdresDTO adresDTO) {
		this.adresDTO = adresDTO;
	}

	public List<FakturaDTO> getListaFakturDTO() {
		return listaFakturDTO;
	}

	public void setListaFakturDTO(List<FakturaDTO> listaFakturDTO) {
		this.listaFakturDTO = listaFakturDTO;
	}

	public Klient stworzKlientaZIdNaPotrzebyFaktury() {
		Klient klient = new Klient(getId(), getImie(), getNazwisko(), getAdresDTO().stworzAdres());
		return klient;
	}

	public Klient stworzKlienta() {
		Klient klient = new Klient(getImie(), getNazwisko(), getAdresDTO().stworzAdres());
		return klient;
	}
}

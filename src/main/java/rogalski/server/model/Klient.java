package rogalski.server.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import rogalski.shared.dto.KlientDTO;

@Entity
@Table(name = "klient", schema = "fakturowanie")
public class Klient {

	@Id
	@SequenceGenerator(name = "klient_id_seq", sequenceName = "fakturowanie.klient_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klient_id_seq")
	@Column(name = "klient_id")
	private Long id;

	@Column(name = "imie")
	private String imie;

	@Column(name = "nazwisko")
	private String nazwisko;

	@Embedded
	private Adres adres;

	@OneToMany(mappedBy = "klient", cascade = CascadeType.ALL)
	private List<Faktura> listaFaktur;

	public Long getId() {
		return id;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public Adres getAdres() {
		return adres;
	}

	public List<Faktura> getListaFaktur() {
		return listaFaktur;
	}

	public void setListaFaktur(List<Faktura> listaFaktur) {
		this.listaFaktur = listaFaktur;
	}

	public Klient(Long id, String imie, String nazwisko, Adres adres) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
	}

	public Klient(String imie, String nazwisko, Adres adres, List<Faktura> listaFaktur) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
		this.listaFaktur = listaFaktur;
	}

	public Klient(String imie, String nazwisko, Adres adres) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
	}

	public Klient() {
	}

	public KlientDTO stworzKlientaDTO() {
		if (getAdres() != null) {
			return new KlientDTO(getId(), getImie(), getNazwisko(), getAdres().stworzAdresDTO());
		} else {
			return new KlientDTO(getId(), getImie(), getNazwisko(), new Adres(null, null, null, null).stworzAdresDTO());
		}
	}
}

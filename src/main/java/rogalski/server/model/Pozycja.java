package rogalski.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ_poyzcji")
@Table(name = "pozycja", schema = "fakturowanie")
public class Pozycja {

	@Id
	@SequenceGenerator(name = "pozycja_id_seq", sequenceName = "fakturowanie.pozycja_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pozycja_id_seq")
	@Column(name = "pozycja_id")
	private long id;

	@Column(name = "nazwa")
	private String nazwa;

	@ManyToOne
	@JoinColumn(name = "nr_faktury")
	private Faktura faktura;

	@Column(name = "vat")
	private Double vat;

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Pozycja(String nazwa, Double vat) {
		super();
		this.nazwa = nazwa;
		this.vat = vat;
	}

	public Pozycja(String nazwa, Faktura faktura, Double vat) {
		super();
		this.nazwa = nazwa;
		this.faktura = faktura;
		this.vat = vat;
	}

	public Pozycja(String nazwa, Faktura faktura) {
		this.nazwa = nazwa;
		this.faktura = faktura;
	}

	public Pozycja() {
	}

	public Pozycja(String nazwa) {
		super();
		this.nazwa = nazwa;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}
}

package rogalski.server.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.PozycjaDTO;

@Entity
@Table(name = "faktura", schema = "fakturowanie")
public class Faktura {

	@Id
	@SequenceGenerator(name = "nr_faktury_seq", sequenceName = "fakturowanie.nr_faktury_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nr_faktury_seq")
	@Column(name = "nr_faktury")
	private Long nrFaktury;

	@OneToMany(mappedBy = "faktura", cascade = CascadeType.ALL)
	private List<Pozycja> pozycja;

	@ManyToOne
	@JoinColumn(name = "klient_id")
	private Klient klient;

	public Long getNrFaktury() {
		return nrFaktury;
	}

	public List<Pozycja> getPozycja() {
		return pozycja;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setNrFaktury(Long nrFaktury) {
		this.nrFaktury = nrFaktury;
	}

	public void setPozycja(List<Pozycja> pozycja) {
		this.pozycja = pozycja;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Faktura(Klient klient) {
		super();
		this.klient = klient;
	}

	public Faktura() {
		super();
	}

	 public FakturaDTO stworzFaktureDTO(List<PozycjaDTO> listaPozycjiDTO) {
	 FakturaDTO fakturaDTO = new FakturaDTO(getNrFaktury(),
	 getKlient().stworzKlientaDTO());
	 fakturaDTO.setListaPozycjiDTO(listaPozycjiDTO);
	 return fakturaDTO;
	 }
}

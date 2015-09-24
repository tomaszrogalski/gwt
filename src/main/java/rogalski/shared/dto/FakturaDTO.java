package rogalski.shared.dto;

import java.util.ArrayList;
import java.util.List;

import rogalski.server.model.Faktura;
import rogalski.server.model.Pozycja;

public class FakturaDTO {

	private Long nrFaktury;

	private KlientDTO klientDTO;

	private List<PozycjaDTO> listaPozycjiDTO;

	/////////////////////////////////

	public FakturaDTO(Long nrFaktury, KlientDTO klientDTO, List<PozycjaDTO> listaPozycjiDTO) {
		super();
		this.nrFaktury = nrFaktury;
		this.klientDTO = klientDTO;
		this.listaPozycjiDTO = listaPozycjiDTO;
	}

	public FakturaDTO(Long nrFaktury, KlientDTO klientDTO) {
		super();
		this.nrFaktury = nrFaktury;
		this.klientDTO = klientDTO;
	}

	public FakturaDTO() {
		super();
	}

	/////////////////////////////////

	public Long getNrFaktury() {
		return nrFaktury;
	}

	public void setNrFaktury(Long nrFaktury) {
		this.nrFaktury = nrFaktury;
	}

	public KlientDTO getKlientDTO() {
		return klientDTO;
	}

	public void setKlientDTO(KlientDTO klientDTO) {
		this.klientDTO = klientDTO;
	}

	public List<PozycjaDTO> getListaPozycjiDTO() {
		return listaPozycjiDTO;
	}

	public void setListaPozycjiDTO(List<PozycjaDTO> listaPozycjiDTO) {
		this.listaPozycjiDTO = listaPozycjiDTO;
	}

	public Faktura stworzFakture() {
		Faktura faktura = new Faktura();
		faktura.setKlient(getKlientDTO().stworzKlientaZIdNaPotrzebyFaktury());
		List<Pozycja> listaPozycji = new ArrayList<>();
		for (PozycjaDTO pozycjaDTO : listaPozycjiDTO) {

			Pozycja pozycja = null;

			if (pozycjaDTO.getTyp() == TypPozycji.PRODUKT) {
				pozycja = pozycjaDTO.stworzProdukt();
			} else if (pozycjaDTO.getTyp() == TypPozycji.USLUGA) {
				pozycja = pozycjaDTO.stworzUsluge();
			}
			pozycja.setFaktura(faktura);
			listaPozycji.add(pozycja);
		}
		faktura.setPozycja(listaPozycji);
		return faktura;
	}
}

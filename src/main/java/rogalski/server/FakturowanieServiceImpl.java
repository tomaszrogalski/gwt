package rogalski.server;

import java.util.List;

import javax.ejb.EJB;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import rogalski.client.FakturowanieService;
import rogalski.server.dao.FakturaDAO;
import rogalski.server.dao.KlientDAO;
import rogalski.server.dao.PozycjaDAO;
import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;

@SuppressWarnings("serial")
public class FakturowanieServiceImpl extends RemoteServiceServlet implements FakturowanieService {

	@EJB
	KlientDAO klientDAO;

	@EJB
	PozycjaDAO pozycjaDAO;

	@EJB
	FakturaDAO fakturaDAO;

	@Override
	public void dodajKlientaDoBazy(KlientDTO klientDTO) {
		klientDAO.stworzKlienta(klientDTO.stworzKlienta());

	}

	@Override
	public void dodajProduktDoBazy(PozycjaDTO pozycjaDTO) {
		pozycjaDAO.stworzProdukt(pozycjaDTO.stworzProdukt());

	}

	@Override
	public void dodajUslugeDoBazy(PozycjaDTO pozycjaDTO) {
		pozycjaDAO.stworzUsluge(pozycjaDTO.stworzUsluge());

	}

	@Override
	public void dodajFaktureDoBazy(FakturaDTO fakturaDTO) {
		fakturaDAO.stworzFakture(fakturaDTO.stworzFakture());
	}

	@Override
	public List<FakturaDTO> wczytajWszystkieFaktury() {
		return fakturaDAO.wczytajWszystkieFaktury();
	}

	@Override
	public FakturaDTO wczytajOstatnioDodanaFakture() {
		return fakturaDAO.wczytajOstatnioDodana();
	}

	@Override
	public List<KlientDTO> wczytajWszystkichKlientow() {
		return klientDAO.wczytajWszystkichKlientow();
	}

	@Override
	public KlientDTO wczytajOstatnioDodanego() {
		return klientDAO.wczytajOstatnioDodanego();
	}

	@Override
	public List<PozycjaDTO> wczytajWszystkiePozycje() {
		return pozycjaDAO.wczytaj();
	}
}

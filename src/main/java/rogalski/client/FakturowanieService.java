package rogalski.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("fakturowanie")
public interface FakturowanieService extends RemoteService {

	void dodajKlientaDoBazy(KlientDTO klientDTO);
	void dodajProduktDoBazy(PozycjaDTO pozycjaDTO);
	void dodajUslugeDoBazy(PozycjaDTO pozycjaDTO);
	void dodajFaktureDoBazy(FakturaDTO fakturaDTO);
	List<FakturaDTO> wczytajWszystkieFaktury();
	FakturaDTO wczytajOstatnioDodanaFakture();
	List<KlientDTO> wczytajWszystkichKlientow();
	KlientDTO wczytajOstatnioDodanego();
	List<PozycjaDTO> wczytajWszystkiePozycje();
}



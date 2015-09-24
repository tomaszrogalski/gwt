package rogalski.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;

public interface FakturowanieServiceAsync {

	void dodajKlientaDoBazy(KlientDTO klientDTO, AsyncCallback<Void> callback);

	void dodajProduktDoBazy(PozycjaDTO pozycjaDTO, AsyncCallback<Void> callback);

	void dodajUslugeDoBazy(PozycjaDTO pozycjaDTO, AsyncCallback<Void> callback);

	void dodajFaktureDoBazy(FakturaDTO fakturaDTO, AsyncCallback<Void> callback);

	void wczytajWszystkieFaktury(AsyncCallback<List<FakturaDTO>> callback);

	void wczytajOstatnioDodanaFakture(AsyncCallback<FakturaDTO> callback);

	void wczytajWszystkichKlientow(AsyncCallback<List<KlientDTO>> callback);

	void wczytajOstatnioDodanego(AsyncCallback<KlientDTO> callback);

	void wczytajWszystkiePozycje(AsyncCallback<List<PozycjaDTO>> callback);

}

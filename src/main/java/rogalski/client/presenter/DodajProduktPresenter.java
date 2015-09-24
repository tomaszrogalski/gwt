package rogalski.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieService;
import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import rogalski.shared.dto.PozycjaDTO;

public class DodajProduktPresenter implements Presenter {

	public interface DodajProduktDisplay {
		public Widget asWidget();

		public void setPresenter(DodajProduktPresenter presenter);

		public PozycjaDTO odbierzZawartoscTextBoxow();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajProduktDisplay display;

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public DodajProduktPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajProduktDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);

	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public DodajProduktDisplay getDisplay() {
		return display;
	}

	private void funkcjaDoFireEvent(PozycjaDTO pozycjaDTO) {
		eventBus.fireEvent(new DodajOstatnioDodanaPozycjeDoWyswietleniaEvent(pozycjaDTO));
	}

	public void onDodajProduktButtonClicked() {
		PozycjaDTO pozycjaDTO = display.odbierzZawartoscTextBoxow();
		dodajDoBazy(pozycjaDTO);
	}

	private void dodajDoBazy(final PozycjaDTO pozycjaDTO) {
		fakturowanieServiceAsync.dodajProduktDoBazy(pozycjaDTO, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				funkcjaDoFireEvent(pozycjaDTO);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("DODAWANIE PRODUKTU -> COS NIE DZIALA");

			}
		});

	}

}
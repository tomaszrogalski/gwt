package rogalski.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieService;
import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import rogalski.client.presenter.HomePresenter.HomeDisplay;
import rogalski.shared.dto.PozycjaDTO;

public class DodajUslugePresenter implements Presenter {

	public interface DodajUslugeDisplay {
		public Widget asWidget();

		public void setPresenter(DodajUslugePresenter presenter);

		public PozycjaDTO odbierzZawartoscTextBoxow();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajUslugeDisplay display;

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public DodajUslugePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajUslugeDisplay display) {
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

	public DodajUslugeDisplay getDisplay() {
		// TODO Auto-generated method stub
		return display;
	}

	private void funkcjaDoFireEvent(PozycjaDTO pozycjaDTO) {
		eventBus.fireEvent(new DodajOstatnioDodanaPozycjeDoWyswietleniaEvent(pozycjaDTO));
	}

	private void dodajDoBazy(final PozycjaDTO pozycjaDTO) {
		fakturowanieServiceAsync.dodajUslugeDoBazy(display.odbierzZawartoscTextBoxow(), new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				funkcjaDoFireEvent(pozycjaDTO);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("DODAWANIE USLUGI -> COS NIE DZIALA");

			}
		});
	}

	public void onDodajUslugeButtonClicked() {
		PozycjaDTO pozycjaDTO = display.odbierzZawartoscTextBoxow();
		dodajDoBazy(pozycjaDTO);

	}

}

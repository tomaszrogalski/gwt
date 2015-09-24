package rogalski.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieService;
import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajOstatnioDodanegoKlientaDoWyswietleniaEvent;
import rogalski.shared.dto.KlientDTO;

public class DodajKlientaPresenter implements Presenter {

	public interface DodajKlientaDisplay {
		public Widget asWidget();

		public KlientDTO odbierzZawartoscTextBoxow();

		public void setPresenter(DodajKlientaPresenter presenter);
	}

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajKlientaDisplay display;

	public DodajKlientaPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajKlientaDisplay display) {
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

	public DodajKlientaDisplay getDisplay() {
		return display;
	}

	private void funkcjaDoFireEvent() {
		eventBus.fireEvent(new DodajOstatnioDodanegoKlientaDoWyswietleniaEvent());
	}

	private void dodajDoBazy(final KlientDTO klientDTO) {
		fakturowanieServiceAsync.dodajKlientaDoBazy(klientDTO, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("DODAWANIE KLIENTA -> COS NIE DZIALA");

			}

			@Override
			public void onSuccess(Void result) {
				funkcjaDoFireEvent();
			}
		});
	}

	public void onDodajKlientaButtonClicked() {
		KlientDTO klientDTO = display.odbierzZawartoscTextBoxow();
		dodajDoBazy(klientDTO);

	}

}

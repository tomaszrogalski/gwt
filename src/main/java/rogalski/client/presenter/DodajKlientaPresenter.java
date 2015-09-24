package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;
import rogalski.client.presenter.WyswietlPozycjePresenter.WyswietlPozycjeDisplay;

public class DodajKlientaPresenter implements Presenter {

	public interface DodajKlientaDisplay {
		public Widget asWidget();

		public void setPresenter(DodajKlientaPresenter presenter);
	}

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

}

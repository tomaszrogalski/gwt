package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoWyswietlKlientowDodawanieKlientaEvent;

public class WyswietlKlientowPresenter implements Presenter {

	public interface WyswietlKlientowDisplay {
		public Widget asWidget();

		public void setPresenter(WyswietlKlientowPresenter presenter);

		public HasWidgets getHtmlPanelNaDodajKlienta();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final WyswietlKlientowDisplay display;

	public WyswietlKlientowPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			WyswietlKlientowDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);

	}

	public void onWyswietlKlientowButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlKlientowDodawanieKlientaEvent());
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public WyswietlKlientowDisplay getDisplay() {
		return display;
	}

	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelNaDodajKlienta().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelNaDodajKlienta().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelNaDodajKlienta().clear();
	}

}

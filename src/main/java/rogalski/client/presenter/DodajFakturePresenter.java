package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoDodajFaktureDodajProduktEvent;
import rogalski.client.event.DodajDoDodajFaktureDodajUslugeEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajProduktEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajUslugiEvent;
import rogalski.client.presenter.WyswietlKlientowPresenter.WyswietlKlientowDisplay;

public class DodajFakturePresenter implements Presenter {

	public interface DodajFaktureDisplay {
		public Widget asWidget();
		public void setPresenter(DodajFakturePresenter presenter);
		public HTMLPanel getHtmlPanelDodajPozycje();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajFaktureDisplay display;

	public DodajFakturePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajFaktureDisplay display) {
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

	public DodajFaktureDisplay getDisplay() {
		return display;
	}
	
	public void onDodajProduktButtonClicked() {
		eventBus.fireEvent(new DodajDoDodajFaktureDodajProduktEvent());
	}
	public void onDodajUslugeButtonClicked() {
		eventBus.fireEvent(new DodajDoDodajFaktureDodajUslugeEvent());
	}
	
	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelDodajPozycje().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelDodajPozycje().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelDodajPozycje().clear();
	}

}
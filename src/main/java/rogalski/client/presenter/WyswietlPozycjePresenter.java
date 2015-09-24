package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoWyswietlKlientowDodawanieKlientaEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajProduktEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajUslugiEvent;

public class WyswietlPozycjePresenter  implements Presenter {

	public interface  WyswietlPozycjeDisplay {
		public Widget asWidget();
		public void setPresenter(WyswietlPozycjePresenter presenter);
		public HTMLPanel getHtmlPanelNaDodajProduktLubUsluge();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final  WyswietlPozycjeDisplay display;
	

	public  WyswietlPozycjePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,  WyswietlPozycjeDisplay display) {
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

	public WyswietlPozycjeDisplay getDisplay() {
		return display;
	}
	public void onDodajProduktButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlPozycjeDodajProduktEvent());
	}
	public void onDodajUslugeButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlPozycjeDodajUslugiEvent());
	}
	
	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelNaDodajProduktLubUsluge().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelNaDodajProduktLubUsluge().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelNaDodajProduktLubUsluge().clear();
	}
	
	
}
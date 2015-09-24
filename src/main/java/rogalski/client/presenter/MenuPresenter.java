package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoHomaDodajFaktureEvent;
import rogalski.client.event.DodajDoHomaWyswietlFakturyEvent;
import rogalski.client.event.DodajDoHomaWyswietlKlientowEvent;
import rogalski.client.event.DodajDoHomaWyswietlPozycjeEvent;

public class MenuPresenter implements Presenter {

	public interface MenuDisplay {
		Widget asWidget();
		public void setPresenter(MenuPresenter presenter);
	}

	private FakturowanieServiceAsync rpcService;
	private HandlerManager eventBus;
	private MenuDisplay display;

	public MenuPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus, MenuDisplay display) {
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

	public void onWyswietlPozycjeButtonClicked() {
		eventBus.fireEvent(new DodajDoHomaWyswietlPozycjeEvent());
	}

	public void onWyswietlKlientowButtonClicked() {
		eventBus.fireEvent(new DodajDoHomaWyswietlKlientowEvent());
	}

	public void onWyswietlFakturyButtonClicked() {
		eventBus.fireEvent(new DodajDoHomaWyswietlFakturyEvent());
	}

	public void onDodajNowaFaktureButtonClicked() {
		eventBus.fireEvent(new DodajDoHomaDodajFaktureEvent());
	}

	public MenuDisplay getDisplay() {
		return display;
	}

}

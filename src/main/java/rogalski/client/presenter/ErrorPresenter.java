package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoHomaDodajFaktureEvent;
import rogalski.client.event.DodajDoHomaWyswietlFakturyEvent;
import rogalski.client.event.DodajDoHomaWyswietlKlientowEvent;
import rogalski.client.event.DodajDoHomaWyswietlPozycjeEvent;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;

public class ErrorPresenter implements Presenter {

	public interface ErrorDisplay {
		Widget asWidget();

		public void setPresenter(ErrorPresenter presenter);
	}

	private FakturowanieServiceAsync rpcService;
	private HandlerManager eventBus;
	private ErrorDisplay display;

	public ErrorPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus, ErrorDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
	}

	public ErrorDisplay getDisplay() {
		return display;
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}

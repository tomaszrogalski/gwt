package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;

public class WyswietlPozycjePresenter  implements Presenter {

	public interface  WyswietlPozycjeDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final  WyswietlPozycjeDisplay display;

	public  WyswietlPozycjePresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,  WyswietlPozycjeDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;

	}

	@Override
	public void go(HasWidgets container) {
		 container.clear();
		    container.add(display.asWidget());
	}

	public WyswietlPozycjeDisplay getDisplay() {
		return display;
	}
	
	
}
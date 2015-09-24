package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;

public class WyswietlKlientowPresenter implements Presenter {

	public interface  WyswietlKlientowDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final  WyswietlKlientowDisplay display;

	public  WyswietlKlientowPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,  WyswietlKlientowDisplay display) {
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

	public WyswietlKlientowDisplay getDisplay() {
		return display;
	}
	
	
}

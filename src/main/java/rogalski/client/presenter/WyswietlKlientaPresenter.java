package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;

public class WyswietlKlientaPresenter implements Presenter {

	public interface  WyswietlKlientaDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final  WyswietlKlientaDisplay display;

	public  WyswietlKlientaPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,  WyswietlKlientaDisplay display) {
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
}

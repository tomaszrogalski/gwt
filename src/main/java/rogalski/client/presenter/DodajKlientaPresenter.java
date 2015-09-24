package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;

public class DodajKlientaPresenter implements Presenter {

	public interface DodajKlientaDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajKlientaDisplay display;

	public DodajKlientaPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,
			DodajKlientaDisplay display) {
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

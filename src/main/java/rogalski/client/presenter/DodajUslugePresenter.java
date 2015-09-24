package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;

public class DodajUslugePresenter implements Presenter {
	
	public interface DodajUslugeDisplay {
		public Widget asWidget();

	}
	
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajUslugeDisplay display;

	public DodajUslugePresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,
			DodajUslugeDisplay display) {
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

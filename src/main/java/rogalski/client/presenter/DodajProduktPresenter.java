package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;

public class DodajProduktPresenter implements Presenter {

	public interface DodajProduktDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajProduktDisplay display;

	public DodajProduktPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,
			DodajProduktDisplay display) {
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

	public DodajProduktDisplay getDisplay() {
		return display;
	}

}
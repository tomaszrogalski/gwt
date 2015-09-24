package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;
import rogalski.client.presenter.WyswietlKlientowPresenter.WyswietlKlientowDisplay;

public class DodajFakturePresenter implements Presenter {

	public interface DodajFaktureDisplay {
		public Widget asWidget();

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajFaktureDisplay display;

	public DodajFakturePresenter(GreetingServiceAsync rpcService, HandlerManager eventBus,
			DodajFaktureDisplay display) {
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

	public DodajFaktureDisplay getDisplay() {
		return display;
	}

}
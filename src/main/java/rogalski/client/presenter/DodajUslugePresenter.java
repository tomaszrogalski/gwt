package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.presenter.HomePresenter.HomeDisplay;

public class DodajUslugePresenter implements Presenter {
	
	public interface DodajUslugeDisplay {
		public Widget asWidget();
		public void setPresenter(DodajUslugePresenter presenter);
	}
	
	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajUslugeDisplay display;

	public DodajUslugePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajUslugeDisplay display) {
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

	public DodajUslugeDisplay getDisplay() {
		// TODO Auto-generated method stub
		return display;
	}



}

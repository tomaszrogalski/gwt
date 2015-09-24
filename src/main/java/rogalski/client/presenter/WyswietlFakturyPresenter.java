package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.presenter.HomePresenter.HomeDisplay;

public class WyswietlFakturyPresenter implements Presenter {

	public interface WyswietlFakturyDisplay {
		public Widget asWidget();
		public void setPresenter(WyswietlFakturyPresenter presenter);
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final WyswietlFakturyDisplay display;

	public WyswietlFakturyPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			WyswietlFakturyDisplay display) {
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

	public WyswietlFakturyDisplay getDisplay() {
		// TODO Auto-generated method stub
		return display;
	}
}

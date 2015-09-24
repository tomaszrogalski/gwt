package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieServiceAsync;

public class HomePresenter implements Presenter {

	public interface HomeDisplay {
		public Widget asWidget();

		public HTMLPanel getHtmlPanelRoboczy();

		public HTMLPanel getPanelMenu();

		public void setPresenter(HomePresenter presenter);

	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final HomeDisplay display;

	public HomePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus, HomeDisplay display) {
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

	public void dodajDoPaneluMenu(Widget widget) {

		this.display.getPanelMenu().add(widget);
	}

	public HomeDisplay getDisplay() {
		return display;
	}

	public void dodajDoPaneluRoboczego(Widget widget) {
		if (!this.display.getHtmlPanelRoboczy().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelRoboczy().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelRoboczy().clear();
	}
}

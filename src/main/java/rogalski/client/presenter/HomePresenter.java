package rogalski.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.sun.java.swing.plaf.windows.resources.windows;

import rogalski.client.GreetingServiceAsync;
import rogalski.client.event.StworzMenuPresenterEvent;

public class HomePresenter implements Presenter {

	public interface HomeDisplay {
		public Widget asWidget();

		public HTMLPanel getPanelMenu();

		public HTMLPanel getHtmlPanelRoboczy();
		public void setPresenter(HomePresenter presenter) ;

	}

	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final HomeDisplay display;

	public HomePresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, HomeDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
//		eventBus.fireEvent(new StworzMenuPresenterEvent());
	}

	// HandlerRegistration

	@Override
	public void go(HasWidgets container) {
		container.clear();

		container.add(display.asWidget());
	}

	public void dodajDoPaneluMenu(Widget widget) {
		
		this.display.getPanelMenu().add(widget);
	}
	
	public void onWyswietlKlientowButtonClicked() {
		eventBus.fireEvent(new StworzMenuPresenterEvent());
	}


	public HomeDisplay getDisplay() {
		return display;
	}

	public void dodajDoPanelu2(Widget widget) {
		this.display.getHtmlPanelRoboczy().add(widget);
		
	}

}

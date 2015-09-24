package rogalski.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.GreetingServiceAsync;
import rogalski.client.event.DodajDoPaneluWyswietlKlientowEvent;
import rogalski.client.view.MenuView;

public class MenuPresenter implements Presenter {

	public interface MenuDisplay {
		Widget asWidget();

		public void setPresenter(MenuPresenter presenter);

		// public HasClickHandlers getButtonWyswietlKlientow();

	}

	private GreetingServiceAsync rpcService;
	private HandlerManager eventBus;
	private MenuDisplay display;

	public MenuPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, MenuDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		// bind();
	}
	// void bind(){
	// this.display.getButtonWyswietlKlientow().addClickHandler(new
	// ClickHandler() {
	//
	// @Override
	// public void onClick(ClickEvent event) {
	// Window.alert("klient bind w onclick");
	// eventBus.fireEvent(new DodajDoPaneluWyswietlKlientowEvent());
	//
	// }
	// });
	// }

	// public MenuPresenter() {
	// super();
	// Window.alert("ctor presenterPusty");
	// this.display.setPresenter(this);
	//
	// }

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		this.display.setPresenter(this);
	}

	public void onWyswietlPozycjeButtonClicked() {
		Window.alert("NIE DZIA£AMmmmm");
	}

	public void onWyswietlKlientowButtonClicked() {
		 eventBus.fireEvent(new DodajDoPaneluWyswietlKlientowEvent());
	}

	public void onWyswietlFakturyButtonClicked() {

	}

	public void onDodajNowaFaktureButtonClicked() {

	}

	public MenuDisplay getDisplay() {
		return display;
	}

}

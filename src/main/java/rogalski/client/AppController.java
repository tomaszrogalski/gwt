package rogalski.client;

import org.eclipse.jetty.util.log.Log;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.event.DodajDoPaneluWyswietlKlientowEvent;
import rogalski.client.event.StworzMenuPresenterEvent;
import rogalski.client.presenter.HomePresenter;
import rogalski.client.presenter.HomePresenter.HomeDisplay;
import rogalski.client.presenter.MenuPresenter;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;
import rogalski.client.presenter.Presenter;
import rogalski.client.presenter.WyswietlKlientowPresenter;
import rogalski.client.view.HomeView;
import rogalski.client.view.MenuView;
import rogalski.client.view.WyswietlKlientowView;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final GreetingServiceAsync rpcService;
	private HasWidgets kontener;
	private HomeDisplay homeDisplay;
	private MenuDisplay menuDisplay;
	private HomePresenter homePresenter;

	public AppController(GreetingServiceAsync rpcService, HandlerManager eventBus) {

		this.eventBus = eventBus;
		this.rpcService = rpcService;
		homeDisplay = new HomeView();
		homePresenter = new HomePresenter(rpcService, eventBus, homeDisplay);
		bind();

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		if (token.equals("1")) {

			odpalHome();
		} else if (token.equals("2")) {
			odpalMenu();

		}

		else if (token.equals("3")) {
			odpalMenuInHome();

		}
	}

	private void odpalMenuInHome() {
		
		menuDisplay = new MenuView();
		MenuPresenter presenter = new MenuPresenter(rpcService, eventBus, menuDisplay);
		presenter.go(kontener);
		homePresenter.go(kontener);
		homePresenter.dodajDoPaneluMenu(presenter.getDisplay().asWidget());
	}

	private void odpalHome() {
		
		homePresenter.go(kontener);

	}

	private void odpalMenu() {
	
		menuDisplay = new MenuView();
		MenuPresenter presenter = new MenuPresenter(rpcService, eventBus, menuDisplay);
		presenter.go(kontener);

	}

	private void bind() {
		History.addValueChangeHandler(this);


		eventBus.addHandler(StworzMenuPresenterEvent.TYPE, new StworzMenuPresenterEvent.StworzMenuPresenterHandler() {

			@Override
			public void onStworzMenuPresenter(StworzMenuPresenterEvent event) {
				
				menuDisplay = new MenuView();
				MenuPresenter presenter = new MenuPresenter(rpcService, eventBus, menuDisplay);
				presenter.go(kontener);
				homePresenter.go(kontener);
				homePresenter.dodajDoPaneluMenu(presenter.getDisplay().asWidget());
//				 odpalMenuInHome();
//				History.newItem("3");
//				Window.alert("4");
//				menuDisplay = new MenuView();
//				Window.alert("5");
//				MenuPresenter presenter = new MenuPresenter(rpcService, eventBus, menuDisplay);
//				
//				Window.alert("6");
//				homePresenter.dodajDoPaneluMenu(menuDisplay.asWidget());
//				Window.alert("7");

			}
		});
		
		eventBus.addHandler(DodajDoPaneluWyswietlKlientowEvent.TYPE, new DodajDoPaneluWyswietlKlientowEvent.DodajDoPaneluWyswietlKlientowHandler() {
			
			@Override
			public void onDodajDoPaneluWyswietlKlientow(DodajDoPaneluWyswietlKlientowEvent event) {
				WyswietlKlientowPresenter a = new WyswietlKlientowPresenter(rpcService, eventBus, new WyswietlKlientowView());
				a.go(kontener);
				homePresenter.go(kontener);
				homePresenter.dodajDoPanelu2(a.getDisplay().asWidget());
				
			}
		});


	}

	@Override
	public void go(final HasWidgets kontener) {
		this.kontener = kontener;

		if (History.getToken().equals("")) {
			History.newItem("1");
		} 
		else {
			History.fireCurrentHistoryState();
		}

	}

}

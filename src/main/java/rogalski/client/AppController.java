package rogalski.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import rogalski.client.event.DodajDoDodajFaktureDodajProduktEvent;
import rogalski.client.event.DodajDoDodajFaktureDodajUslugeEvent;
import rogalski.client.event.DodajDoHomaDodajFaktureEvent;
import rogalski.client.event.DodajDoHomaWyswietlFakturyEvent;
import rogalski.client.event.DodajDoHomaWyswietlKlientowEvent;
import rogalski.client.event.DodajDoHomaWyswietlPozycjeEvent;
import rogalski.client.event.DodajDoWyswietlKlientowDodawanieKlientaEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajProduktEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajUslugiEvent;
import rogalski.client.presenter.DodajFakturePresenter;
import rogalski.client.presenter.DodajKlientaPresenter;
import rogalski.client.presenter.DodajProduktPresenter;
import rogalski.client.presenter.DodajUslugePresenter;
import rogalski.client.presenter.HomePresenter;
import rogalski.client.presenter.HomePresenter.HomeDisplay;
import rogalski.client.presenter.MenuPresenter;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;
import rogalski.client.presenter.Presenter;
import rogalski.client.presenter.WyswietlFakturyPresenter;
import rogalski.client.presenter.WyswietlKlientowPresenter;
import rogalski.client.presenter.WyswietlPozycjePresenter;
import rogalski.client.view.DodajFaktureView;
import rogalski.client.view.DodajKlientaView;
import rogalski.client.view.DodajProduktView;
import rogalski.client.view.DodajUslugeView;
import rogalski.client.view.ErrorView;
import rogalski.client.view.HomeView;
import rogalski.client.view.MenuView;
import rogalski.client.view.WyswietlFakturyView;
import rogalski.client.view.WyswietlKlientowView;
import rogalski.client.view.WyswietlPozycjeView;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final FakturowanieServiceAsync rpcService;
	private HasWidgets kontener;
	private WyswietlPozycjePresenter wyswietlPozycjePresenter;
	private WyswietlKlientowPresenter wyswietlKlientowPresenter;
	private HomePresenter homePresenter;
	private DodajFakturePresenter dodajFakturePresenter;

	public AppController(FakturowanieServiceAsync rpcService, HandlerManager eventBus) {

		this.eventBus = eventBus;
		this.rpcService = rpcService;
		homePresenter = new HomePresenter(rpcService, eventBus, new HomeView());
		bind();

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		if (token.equals("home")) {

			DodajDoPaneluStartowegoHome();
		} else if (token.equals("error")) {
			DodajDoPaneluStartowegoError();

		}

	}

	

	private void odpalMenuInHome() {
		//
		// menuDisplay = new MenuView();
		// MenuPresenter presenter = new MenuPresenter(rpcService, eventBus,
		// menuDisplay);
		// presenter.go(kontener);
		// homePresenter.go(kontener);
		// homePresenter.dodajDoPaneluMenu(presenter.getDisplay().asWidget());
	}

	// private void odpalHome() {
	//
	// homePresenter.go(kontener);
	//
	// }

	// private void odpalMenu() {
	//
	// menuDisplay = new MenuView();
	// MenuPresenter presenter = new MenuPresenter(rpcService, eventBus,
	// menuDisplay);
	// presenter.go(kontener);
	//
	// }

	@Override
	public void go(final HasWidgets kontener) {
		this.kontener = kontener;

		if (History.getToken().equals("")) {
			History.newItem("home");

		} else if (!History.getToken().equals("") && !History.getToken().equals("home")) {
			History.newItem("error");

		} else {
			History.fireCurrentHistoryState();
		}

	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(DodajDoDodajFaktureDodajProduktEvent.getType(),
				new DodajDoDodajFaktureDodajProduktEvent.DodajDoDodajFaktureDodajProduktHandler() {

					@Override
					public void onDodajDoDodajFaktureDodajProdukt(DodajDoDodajFaktureDodajProduktEvent event) {
						DodajDoDodajFaktureDodajProdukt();
					}

				});

		eventBus.addHandler(DodajDoDodajFaktureDodajUslugeEvent.getType(),
				new DodajDoDodajFaktureDodajUslugeEvent.DodajDoDodajFaktureDodajUslugeHandler() {

					@Override
					public void onDodajDoDodajFaktureDodajUsluge(DodajDoDodajFaktureDodajUslugeEvent event) {
						DodajDoDodajFaktureDodajUsluge();
					}
				});

		eventBus.addHandler(DodajDoHomaDodajFaktureEvent.getType(),
				new DodajDoHomaDodajFaktureEvent.DodajDoHomaDodajFaktureHandler() {

					@Override
					public void onDodajDoHomaDodajFakture(DodajDoHomaDodajFaktureEvent event) {
						DodajDoHomaDodajFakture();
					}
				});

		eventBus.addHandler(DodajDoHomaWyswietlFakturyEvent.getType(),
				new DodajDoHomaWyswietlFakturyEvent.DodajDoHomaWyswietlFakturyHandler() {

					@Override
					public void onDodajDoHomaWyswietlFaktury(DodajDoHomaWyswietlFakturyEvent event) {
						DodajDoHomaWyswietlFaktury();
					}
				});

		eventBus.addHandler(DodajDoHomaWyswietlKlientowEvent.getType(),
				new DodajDoHomaWyswietlKlientowEvent.DodajDoHomaWyswietlKlientowHandler() {

					@Override
					public void onDodajDoHomaWyswietlKlientow(DodajDoHomaWyswietlKlientowEvent event) {
						DodajDoHomaWyswietlKlientow();
					}
				});

		eventBus.addHandler(DodajDoHomaWyswietlPozycjeEvent.getType(),
				new DodajDoHomaWyswietlPozycjeEvent.DodajDoHomaWyswietlPozycjeHandler() {

					@Override
					public void onDodajDoHomaWyswietlPozycje(DodajDoHomaWyswietlPozycjeEvent event) {
						DodajDoHomaWyswietlPozycje();
					}
				});

		eventBus.addHandler(DodajDoWyswietlKlientowDodawanieKlientaEvent.getType(),
				new DodajDoWyswietlKlientowDodawanieKlientaEvent.DodajDoWyswietlKlientowDodawanieKlientaHandler() {

					@Override
					public void onDodajDoWyswietlKlientowDodawanieKlienta(
							DodajDoWyswietlKlientowDodawanieKlientaEvent event) {
						DodajDoWyswietlKlientowDodawanieKlienta();
					}
				});

		eventBus.addHandler(DodajDoWyswietlPozycjeDodajProduktEvent.getType(),
				new DodajDoWyswietlPozycjeDodajProduktEvent.DodajDoWyswietlPozycjeDodajProduktHandler() {

					@Override
					public void onDodajDoWyswietlPozycjeDodajProdukt(DodajDoWyswietlPozycjeDodajProduktEvent event) {
						DodajDoWyswietlPozycjeDodajProdukt();
					}
				});

		eventBus.addHandler(DodajDoWyswietlPozycjeDodajUslugiEvent.getType(),
				new DodajDoWyswietlPozycjeDodajUslugiEvent.DodajDoWyswietlPozycjeDodajUslugiHandler() {

					@Override
					public void onDodajDoWyswietlPozycjeDodajUslugi(DodajDoWyswietlPozycjeDodajUslugiEvent event) {
						DodajDoWyswietlPozycjeDodajUslugi();
					}
				});
	}

	private void DodajDoDodajFaktureDodajProdukt() {

		DodajProduktPresenter dodajProduktPresenter = new DodajProduktPresenter(rpcService, eventBus,
				new DodajProduktView());
		dodajProduktPresenter.go(kontener);

		dodajFakturePresenter.dodajDoPanelu(dodajProduktPresenter.getDisplay().asWidget());
		dodajFakturePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(dodajFakturePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);

	}

	private void DodajDoDodajFaktureDodajUsluge() {

		DodajUslugePresenter dodajUslugePresenter = new DodajUslugePresenter(rpcService, eventBus,
				new DodajUslugeView());
		dodajUslugePresenter.go(kontener);

		dodajFakturePresenter.dodajDoPanelu(dodajUslugePresenter.getDisplay().asWidget());
		dodajFakturePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(dodajFakturePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);

	}

	private void DodajDoHomaDodajFakture() {

		dodajFakturePresenter = new DodajFakturePresenter(rpcService, eventBus, new DodajFaktureView());
		dodajFakturePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(dodajFakturePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);
	}

	private void DodajDoHomaWyswietlFaktury() {

		WyswietlFakturyPresenter wyswietlFakturyPresenter = new WyswietlFakturyPresenter(rpcService, eventBus,
				new WyswietlFakturyView());
		wyswietlFakturyPresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(wyswietlFakturyPresenter.getDisplay().asWidget());
		homePresenter.go(kontener);
	}

	private void DodajDoHomaWyswietlKlientow() {

		wyswietlKlientowPresenter = new WyswietlKlientowPresenter(rpcService, eventBus, new WyswietlKlientowView());

		wyswietlKlientowPresenter.go(kontener);
		homePresenter.go(kontener);
		homePresenter.dodajDoPaneluRoboczego(wyswietlKlientowPresenter.getDisplay().asWidget());
	}

	private void DodajDoHomaWyswietlPozycje() {

		wyswietlPozycjePresenter = new WyswietlPozycjePresenter(rpcService, eventBus, new WyswietlPozycjeView());
		wyswietlPozycjePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(wyswietlPozycjePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);
	}

	private void DodajDoWyswietlKlientowDodawanieKlienta() {

		DodajKlientaPresenter dodajKlientaPresenter = new DodajKlientaPresenter(rpcService, eventBus,
				new DodajKlientaView());
		dodajKlientaPresenter.go(kontener);

		wyswietlKlientowPresenter.dodajDoPanelu(dodajKlientaPresenter.getDisplay().asWidget());
		wyswietlKlientowPresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(wyswietlKlientowPresenter.getDisplay().asWidget());
		homePresenter.go(kontener);

	}

	private void DodajDoWyswietlPozycjeDodajProdukt() {

		DodajProduktPresenter dodajProduktPresenter = new DodajProduktPresenter(rpcService, eventBus,
				new DodajProduktView());
		dodajProduktPresenter.go(kontener);

		wyswietlPozycjePresenter.dodajDoPanelu(dodajProduktPresenter.getDisplay().asWidget());
		wyswietlPozycjePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(wyswietlPozycjePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);
	}

	private void DodajDoWyswietlPozycjeDodajUslugi() {
		DodajUslugePresenter dodajUslugePresenter = new DodajUslugePresenter(rpcService, eventBus,
				new DodajUslugeView());
		dodajUslugePresenter.go(kontener);

		wyswietlPozycjePresenter.dodajDoPanelu(dodajUslugePresenter.getDisplay().asWidget());
		wyswietlPozycjePresenter.go(kontener);

		homePresenter.dodajDoPaneluRoboczego(wyswietlPozycjePresenter.getDisplay().asWidget());
		homePresenter.go(kontener);

	}

	private void DodajDoPaneluStartowegoHome() {
		MenuPresenter presenter = new MenuPresenter(rpcService, eventBus, new MenuView());
		presenter.go(kontener);
		homePresenter.go(kontener);
		homePresenter.dodajDoPaneluMenu(presenter.getDisplay().asWidget());
	}
	
	private void DodajDoPaneluStartowegoError() {
	}
}

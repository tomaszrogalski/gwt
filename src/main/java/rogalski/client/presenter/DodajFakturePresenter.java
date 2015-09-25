package rogalski.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieService;
import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoDodajFaktureDodajProduktEvent;
import rogalski.client.event.DodajDoDodajFaktureDodajUslugeEvent;
import rogalski.client.event.DodajOstatnioDodanaFaktureDoWyswietleniaEvent;
import rogalski.client.event.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import rogalski.client.event.DodajOstatnioDodanegoKlientaDoWyswietleniaEvent;
import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;

public class DodajFakturePresenter implements Presenter {

	public interface DodajFaktureDisplay {
		public Widget asWidget();

		public void setPresenter(DodajFakturePresenter presenter);

		public HTMLPanel getHtmlPanelDodajPozycje();

		public FakturaDTO odbierzZawartoscZGridITextBoxa();

		DataGrid<KlientDTO> getDataGridListaKlientow();

		DataGrid<PozycjaDTO> getDataGridListaPozycji();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DodajFaktureDisplay display;

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public DodajFakturePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			DodajFaktureDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		dodajDoGrida();
		bind();
	}

	private void bind() {
		eventBus.addHandler(DodajOstatnioDodanegoKlientaDoWyswietleniaEvent.getType(),
				new DodajOstatnioDodanegoKlientaDoWyswietleniaEvent.DodajOstatnioDodanegoKlientaDoWyswietleniaHandler() {

					@Override
					public void onDodajOstatnioDodanegoKlientaDoWyswietlenia(
							DodajOstatnioDodanegoKlientaDoWyswietleniaEvent event) {
						fakturowanieServiceAsync.wczytajOstatnioDodanego(new AsyncCallback<KlientDTO>() {

							@Override
							public void onSuccess(KlientDTO result) {
								List<KlientDTO> listaKlientow = new ArrayList<>();
								listaKlientow.addAll(display.getDataGridListaKlientow().getVisibleItems());
								listaKlientow.add(result);
								display.getDataGridListaKlientow().setRowData(listaKlientow);

							}

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("WCZYTYWANIE KLIENTA -> COS NIE DZIALA");

							}
						});
					}

				});
		
		eventBus.addHandler(DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.getType(),
				new DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.DodajOstatnioDodanaPozycjeDoWyswietleniaHandler() {

					@Override
					public void onDodajOstatnioDodanaPozycjeDoWyswietlenia(
							DodajOstatnioDodanaPozycjeDoWyswietleniaEvent event) {
						List<PozycjaDTO> listaPozycji = new ArrayList<>();
						listaPozycji.addAll(display.getDataGridListaPozycji().getVisibleItems());
						listaPozycji.add(event.getPozycjaDTO());
						display.getDataGridListaPozycji().setRowData(listaPozycji);

					}
				});
	}

	private void dodajDoGrida() {
		fakturowanieServiceAsync.wczytajWszystkichKlientow(new AsyncCallback<List<KlientDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIA£A - WCZYTAJ KLIENTOW");

			}

			@Override
			public void onSuccess(List<KlientDTO> result) {
				display.getDataGridListaKlientow().setRowData(result);

			}
		});

		fakturowanieServiceAsync.wczytajWszystkiePozycje(new AsyncCallback<List<PozycjaDTO>>() {

			@Override
			public void onSuccess(List<PozycjaDTO> result) {
				display.getDataGridListaPozycji().setRowData(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIA£A - WCZYTAJ POZYCJE");

			}
		});

	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public DodajFaktureDisplay getDisplay() {
		return display;
	}

	public void onDodajProduktButtonClicked() {
		eventBus.fireEvent(new DodajDoDodajFaktureDodajProduktEvent());
	}

	public void onDodajUslugeButtonClicked() {
		eventBus.fireEvent(new DodajDoDodajFaktureDodajUslugeEvent());
	}

	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelDodajPozycje().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelDodajPozycje().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelDodajPozycje().clear();
	}

	private void funkcjaDoFireEvent() {
		eventBus.fireEvent(new DodajOstatnioDodanaFaktureDoWyswietleniaEvent());
	}

	private void dodajDoBazy(final FakturaDTO fakturaDTO) {
		fakturowanieServiceAsync.dodajFaktureDoBazy(fakturaDTO, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("DODAWANIE FAKTURY -> COS NIE DZIALA");

			}

			@Override
			public void onSuccess(Void result) {
				funkcjaDoFireEvent();
			}
		});
	}

	public void onDodajFaktureButtonClicked() {
		FakturaDTO fakturaDTO = display.odbierzZawartoscZGridITextBoxa();
		dodajDoBazy(fakturaDTO);

	}

}
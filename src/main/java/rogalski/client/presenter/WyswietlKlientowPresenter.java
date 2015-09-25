package rogalski.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.FakturowanieService;
import rogalski.client.FakturowanieServiceAsync;
import rogalski.client.event.DodajDoWyswietlKlientowDodawanieKlientaEvent;
import rogalski.client.event.DodajOstatnioDodanegoKlientaDoWyswietleniaEvent;
import rogalski.shared.dto.KlientDTO;

public class WyswietlKlientowPresenter implements Presenter {

	public interface WyswietlKlientowDisplay {
		public Widget asWidget();

		public void setPresenter(WyswietlKlientowPresenter presenter);

		public HasWidgets getHtmlPanelNaDodajKlienta();

		DataGrid<KlientDTO> getDataGridWyswietlKlientow();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final WyswietlKlientowDisplay display;

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public WyswietlKlientowPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			WyswietlKlientowDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		bind();
		dodajDoGrida();
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
								listaKlientow.addAll(display.getDataGridWyswietlKlientow().getVisibleItems());
								listaKlientow.add(result);
								display.getDataGridWyswietlKlientow().setRowData(listaKlientow);

							}

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("WCZYTYWANIE KLIENTA -> COS NIE DZIALA");

							}
						});
					}

				});

	}

	private void dodajDoGrida() {
		fakturowanieServiceAsync.wczytajWszystkichKlientow(new AsyncCallback<List<KlientDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIA£A - WCZYTAJ KLIENTA");
			}

			@Override
			public void onSuccess(List<KlientDTO> result) {
				display.getDataGridWyswietlKlientow().setRowData(result);
			}

		});
	}

	public void onWyswietlKlientowButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlKlientowDodawanieKlientaEvent());

	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public WyswietlKlientowDisplay getDisplay() {
		return display;
	}

	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelNaDodajKlienta().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelNaDodajKlienta().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelNaDodajKlienta().clear();
	}

}

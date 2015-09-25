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
import rogalski.client.event.DodajDoWyswietlPozycjeDodajProduktEvent;
import rogalski.client.event.DodajDoWyswietlPozycjeDodajUslugiEvent;
import rogalski.client.event.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;

public class WyswietlPozycjePresenter implements Presenter {

	public interface WyswietlPozycjeDisplay {
		public Widget asWidget();

		public void setPresenter(WyswietlPozycjePresenter presenter);

		public HTMLPanel getHtmlPanelNaDodajProduktLubUsluge();

		DataGrid<PozycjaDTO> getDataGridWyswietlPozycje();

	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final WyswietlPozycjeDisplay display;
	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public WyswietlPozycjePresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			WyswietlPozycjeDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		bind();
		dodajDoGrida();
	}

	private void bind() {
		eventBus.addHandler(DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.getType(),
				new DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.DodajOstatnioDodanaPozycjeDoWyswietleniaHandler() {

					@Override
					public void onDodajOstatnioDodanaPozycjeDoWyswietlenia(
							DodajOstatnioDodanaPozycjeDoWyswietleniaEvent event) {
						List<PozycjaDTO> listaPozycji = new ArrayList<>();
						listaPozycji.addAll(display.getDataGridWyswietlPozycje().getVisibleItems());
						listaPozycji.add(event.getPozycjaDTO());
						display.getDataGridWyswietlPozycje().setRowData(listaPozycji);

					}
				});

	}

	private void dodajDoGrida() {
		fakturowanieServiceAsync.wczytajWszystkiePozycje(new AsyncCallback<List<PozycjaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIA£A - WCZYTAJ KLIENTA");
			}

			@Override
			public void onSuccess(List<PozycjaDTO> result) {
				display.getDataGridWyswietlPozycje().setRowData(result);
			}

		});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public WyswietlPozycjeDisplay getDisplay() {
		return display;
	}

	public void onDodajProduktButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlPozycjeDodajProduktEvent());
	}

	public void onDodajUslugeButtonClicked() {
		eventBus.fireEvent(new DodajDoWyswietlPozycjeDodajUslugiEvent());
	}

	public void dodajDoPanelu(Widget widget) {
		if (!this.display.getHtmlPanelNaDodajProduktLubUsluge().equals(widget)) {
			czyscPanelRoboczy();
			this.display.getHtmlPanelNaDodajProduktLubUsluge().add(widget);
		}
	}

	private void czyscPanelRoboczy() {
		this.display.getHtmlPanelNaDodajProduktLubUsluge().clear();
	}

}
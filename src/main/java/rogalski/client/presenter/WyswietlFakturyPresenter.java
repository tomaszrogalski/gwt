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
import rogalski.client.event.DodajOstatnioDodanaFaktureDoWyswietleniaEvent;
import rogalski.client.event.DodajOstatnioDodanegoKlientaDoWyswietleniaEvent;
import rogalski.client.presenter.HomePresenter.HomeDisplay;
import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.KlientDTO;

public class WyswietlFakturyPresenter implements Presenter {

	public interface WyswietlFakturyDisplay {
		public Widget asWidget();

		public void setPresenter(WyswietlFakturyPresenter presenter);

		DataGrid<FakturaDTO> getDataGridWyswietlFaktury();
	}

	private final FakturowanieServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final WyswietlFakturyDisplay display;

	private final FakturowanieServiceAsync fakturowanieServiceAsync = GWT.create(FakturowanieService.class);

	public WyswietlFakturyPresenter(FakturowanieServiceAsync rpcService, HandlerManager eventBus,
			WyswietlFakturyDisplay display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		dodajDoGrida();
		bind();
	}

	private void dodajDoGrida() {
		fakturowanieServiceAsync.wczytajWszystkieFaktury(new AsyncCallback<List<FakturaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIA£A - WCZYTAJ FAKTURY");
			}

			@Override
			public void onSuccess(List<FakturaDTO> result) {
				display.getDataGridWyswietlFaktury().setRowData(result);
			}

		});
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

	private void bind() {

		eventBus.addHandler(DodajOstatnioDodanaFaktureDoWyswietleniaEvent.getType(),

		new DodajOstatnioDodanaFaktureDoWyswietleniaEvent.DodajOstatnioDodanaFaktureDoWyswietleniaHandler() {

			@Override
			public void onDodajOstatnioDodanaFaktureDoWyswietlenia(
					DodajOstatnioDodanaFaktureDoWyswietleniaEvent event) {
				fakturowanieServiceAsync.wczytajOstatnioDodanaFakture(new AsyncCallback<FakturaDTO>() {

					@Override
					public void onFailure(Throwable caught) {

						Window.alert("WCZYTYWANIE Faktury -> COS NIE DZIALA");

					}

					@Override
					public void onSuccess(FakturaDTO result) {
						List<FakturaDTO> listaFaktur = new ArrayList<>();
						listaFaktur.addAll(display.getDataGridWyswietlFaktury().getVisibleItems());
						listaFaktur.add(result);
						display.getDataGridWyswietlFaktury().setRowData(listaFaktur);

					}
				});
			}

		});

	}
}

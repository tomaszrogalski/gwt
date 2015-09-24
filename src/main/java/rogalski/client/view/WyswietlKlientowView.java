package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.MenuPresenter;
import rogalski.client.presenter.WyswietlFakturyPresenter;
import rogalski.client.presenter.WyswietlKlientowPresenter;
import rogalski.client.presenter.WyswietlKlientowPresenter.WyswietlKlientowDisplay;
import rogalski.client.presenter.WyswietlPozycjePresenter.WyswietlPozycjeDisplay;
import rogalski.shared.dto.KlientDTO;

public class WyswietlKlientowView extends Composite implements WyswietlKlientowDisplay {

	private static WyswietlKlientowViewUiBinder uiBinder = GWT.create(WyswietlKlientowViewUiBinder.class);

	interface WyswietlKlientowViewUiBinder extends UiBinder<Widget, WyswietlKlientowView> {
	}

	@UiField
	DataGrid<KlientDTO> dataGridWyswietlKlientow;

	@UiField
	Button buttonDodajNowegoKlienta;

	@UiField
	HTMLPanel htmlPanelNaDodajKlienta;

	private WyswietlKlientowPresenter presenter;

	public WyswietlKlientowView() {
		initWidget(uiBinder.createAndBindUi(this));
		stworzDataGrid();

	}

	private void stworzDataGrid() {
		TextColumn<KlientDTO> textColumnImie = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getImie();
			}
		};
		TextColumn<KlientDTO> textColumnNazwisko = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getNazwisko();
			}
		};
		TextColumn<KlientDTO> textColumnUlica = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getUlica();
			}
		};
		TextColumn<KlientDTO> textColumnNrDomu = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getNrDomu();
			}
		};
		TextColumn<KlientDTO> textColumnMiejscowosc = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getMiejscowosc();
			}
		};
		TextColumn<KlientDTO> textColumnKodPocztowy = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getKodPocztowy();
			}
		};

		dataGridWyswietlKlientow.setWidth("100%");
		dataGridWyswietlKlientow.setHeight("300px");

		dataGridWyswietlKlientow.addColumn(textColumnImie, "IMIE");
		dataGridWyswietlKlientow.addColumn(textColumnNazwisko, "NAZWISKO");
		dataGridWyswietlKlientow.addColumn(textColumnUlica, "ULICA");
		dataGridWyswietlKlientow.addColumn(textColumnNrDomu, "NR DOMU");
		dataGridWyswietlKlientow.addColumn(textColumnMiejscowosc, "MIEJSCOWOŒÆ");
		dataGridWyswietlKlientow.addColumn(textColumnKodPocztowy, "KOD POCZTOWY");
	}

	@UiHandler("buttonDodajNowegoKlienta")
	void dodajClick(ClickEvent e) {
		presenter.onWyswietlKlientowButtonClicked();
	}

	public DataGrid<KlientDTO> getDataGridWyswietlKlientow() {
		return dataGridWyswietlKlientow;
	}

	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(WyswietlKlientowPresenter presenter) {
		this.presenter = presenter;

	}

	public HTMLPanel getHtmlPanelNaDodajKlienta() {
		return htmlPanelNaDodajKlienta;
	}
	
	
}

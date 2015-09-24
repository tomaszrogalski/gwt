package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.WyswietlPozycjePresenter.WyswietlPozycjeDisplay;
import rogalski.shared.dto.PozycjaDTO;

public class WyswietlPozycjeView extends Composite implements WyswietlPozycjeDisplay {

	private static WyswietlPozycjeViewUiBinder uiBinder = GWT.create(WyswietlPozycjeViewUiBinder.class);

	interface WyswietlPozycjeViewUiBinder extends UiBinder<Widget, WyswietlPozycjeView> {
	}

	@UiField
	DataGrid<PozycjaDTO> dataGridWyswietlPozycje;

	@UiField
	Button buttonDodajNowyProdukt;

	@UiField
	Button buttonDodajNowaUsluge;

	@UiField
	HTMLPanel htmlPanelNaDodajProduktLubUsluge;

	public WyswietlPozycjeView() {
		initWidget(uiBinder.createAndBindUi(this));
		stworzDataGrid();
	}

	private void stworzDataGrid() {
		TextColumn<PozycjaDTO> textColumnTyp = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getTyp().toString();
			}
		};

		TextColumn<PozycjaDTO> textColumnNazwa = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {

				return pozycjaDTO.getNazwa();
			}
		};
		TextColumn<PozycjaDTO> textColumnCena = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				if (pozycjaDTO.getProduktDTO().getCena() == 0.0) {
					return "-";
				} else {
					return pozycjaDTO.getProduktDTO().getCena().toString();
				}
			}
		};
		TextColumn<PozycjaDTO> textColumnCenaZaGodzine = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				if (pozycjaDTO.getUslugaDTO().getCenaZaGodzine() == 0.0) {
					return "-";
				} else {
					return pozycjaDTO.getUslugaDTO().getCenaZaGodzine().toString();
				}

			}
		};
		TextColumn<PozycjaDTO> textColumnJednostka = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getProduktDTO().getJednostka().getSkrotJednostki();
			}
		};

		TextColumn<PozycjaDTO> textColumnVat = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getVat().toString();
			}
		};

		dataGridWyswietlPozycje.setWidth("100%");
		dataGridWyswietlPozycje.setHeight("300px");
		dataGridWyswietlPozycje.addColumn(textColumnTyp, "TYP");
		dataGridWyswietlPozycje.addColumn(textColumnNazwa, "NAZWA");
		dataGridWyswietlPozycje.addColumn(textColumnCena, "CENA(z�)");
		dataGridWyswietlPozycje.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE(z�/h)");
		dataGridWyswietlPozycje.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridWyswietlPozycje.addColumn(textColumnVat, "VAT(%)");

	}

	@UiHandler("buttonDodajNowyProdukt")
	void dodajProdukt(ClickEvent e) {
//		getUiHandlers().buttonAkcjaDodajProdukt();
	}

	@UiHandler("buttonDodajNowaUsluge")
	void dodajUsluge(ClickEvent e) {
//		getUiHandlers().buttonAkcjaDodajUsluge();
	}

	public DataGrid<PozycjaDTO> getDataGridWyswietlPozycje() {
		return dataGridWyswietlPozycje;
	}

	public Widget asWidget() {
		return this;
	}
}

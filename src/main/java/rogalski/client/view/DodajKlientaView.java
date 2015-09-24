package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.DodajKlientaPresenter.DodajKlientaDisplay;
import rogalski.shared.dto.AdresDTO;
import rogalski.shared.dto.KlientDTO;

public class DodajKlientaView extends Composite implements DodajKlientaDisplay, Editor<KlientDTO> {

	private static DodajKlientaViewUiBinder uiBinder = GWT.create(DodajKlientaViewUiBinder.class);

	interface DodajKlientaViewUiBinder extends UiBinder<Widget, DodajKlientaView> {
	}

	interface Driver extends SimpleBeanEditorDriver<KlientDTO, DodajKlientaView> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	@Path("imie")
	TextBox textBoxImie;

	@UiField
	@Path("nazwisko")
	TextBox textBoxNazwisko;

	@UiField
	@Path("adresDTO.ulica")
	TextBox textBoxUlica;

	@UiField
	@Path("adresDTO.nrDomu")
	TextBox textBoxNrDomu;

	@UiField
	@Path("adresDTO.miejscowosc")
	TextBox textBoxMiejscowosc;

	@UiField
	@Path("adresDTO.kodPocztowy")
	TextBox textBoxKodPocztowy;

	@UiField
	@Ignore
	Label errorLabel;

	@UiField
	Button buttonDodaj;

	public Widget asWidget() {
		return this;
	}

	public DodajKlientaView() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new KlientDTO(null, null, new AdresDTO(null, null, null, null)));

		ustawPlaceHoldery();
	}

	private void ustawPlaceHoldery() {
		textBoxImie.getElement().setPropertyString("placeholder", "Imie");
		textBoxNazwisko.getElement().setPropertyString("placeholder", "Nazwisko");
		textBoxUlica.getElement().setPropertyString("placeholder", "Ulica");
		textBoxMiejscowosc.getElement().setPropertyString("placeholder", "Miejscowosc");
		textBoxKodPocztowy.getElement().setPropertyString("placeholder", "Kod pocztowy(00-000)");
		textBoxNrDomu.getElement().setPropertyString("placeholder", "NrDomu");

	}

	public KlientDTO odbierzZawartoscTextBoxow() {
		KlientDTO klientDTO = driver.flush();
		return klientDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		Window.alert("NIE DZIA£AM");
		// if (waliduj()) {
		// getUiHandlers().buttonAkcjaDodajKlienta();
		// driver.edit(new KlientDTO(null, null, new AdresDTO(null, null, null,
		// null)));
	}

}

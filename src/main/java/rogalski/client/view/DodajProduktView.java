package rogalski.client.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.DodajProduktPresenter.DodajProduktDisplay;
import rogalski.shared.dto.Jednostka;
import rogalski.shared.dto.PozycjaDTO;
import rogalski.shared.dto.ProduktDTO;

public class DodajProduktView extends Composite implements DodajProduktDisplay, Editor<PozycjaDTO> {

	private static DodajProduktViewUiBinder uiBinder = GWT.create(DodajProduktViewUiBinder.class);

	interface DodajProduktViewUiBinder extends UiBinder<Widget, DodajProduktView> {
	}
	interface Driver extends SimpleBeanEditorDriver<PozycjaDTO, DodajProduktView> {
	}
	Driver driver = GWT.create(Driver.class);
	
	@UiField
	@Path("nazwa")
	TextBox textBoxNazwa;

	@UiField
	@Path("produktDTO.cena")
	DoubleBox doubleBoxCena;

	// Zrodlo:
	// Poprzedni projekt, internet
	@UiField(provided = true)
	@Path("produktDTO.jednostka")
	ValueListBox<Jednostka> valueListBoxJednostka = new ValueListBox<Jednostka>(new Renderer<Jednostka>() {

		@Override
		public String render(Jednostka object) {
			return object == null ? "" : object.toString();
		}

		@Override
		public void render(Jednostka object, Appendable appendable) throws IOException {
		}

	});

	@UiField
	@Path("vat")
	DoubleBox doubleBoxVAT;

	@UiField
	Button buttonDodaj;

	@UiField
	@Ignore
	Label errorLabel;

	public Widget asWidget() {
		return this;
	}
	
	public DodajProduktView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		driver.initialize(this);
		driver.edit(new PozycjaDTO(null, null, new ProduktDTO(null, null)));

		ustawPlaceHoldery();

		zapelnijValueListBox();
	}
	
	public void zapelnijValueListBox() {
		valueListBoxJednostka.setValue(Jednostka.KILOGRAM);

		List<Jednostka> listaJednostek = new ArrayList<Jednostka>();
		listaJednostek.addAll(java.util.Arrays.asList(Jednostka.values()));
		listaJednostek.remove(Jednostka.BRAK);

		valueListBoxJednostka.setAcceptableValues(listaJednostek);

	}

	private void ustawPlaceHoldery() {
		textBoxNazwa.getElement().setPropertyString("placeholder", "Nazwa");
		doubleBoxCena.getElement().setPropertyString("placeholder", "0.0");
		doubleBoxVAT.getElement().setPropertyString("placeholder", "0.0");

	}

	public PozycjaDTO odbierzZawartoscTextBoxow() {
		PozycjaDTO pozycjaDTO = driver.flush();
		return pozycjaDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		
		Window.alert("NIE DZIA£AM");
//		if (waliduj()) {
//			getUiHandlers().buttonAkcjaDodajProdukt();
//			driver.edit(new PozycjaDTO(null, null, new ProduktDTO(null, null)));
//		}
	}

}

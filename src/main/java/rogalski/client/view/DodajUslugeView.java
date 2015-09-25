package rogalski.client.view;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.DodajUslugePresenter;
import rogalski.client.presenter.DodajUslugePresenter.DodajUslugeDisplay;
import rogalski.client.resources.AppResources;
import rogalski.shared.dto.PozycjaDTO;
import rogalski.shared.dto.UslugaDTO;

public class DodajUslugeView extends Composite implements DodajUslugeDisplay, Editor<PozycjaDTO> {

	private static DodajUslugeViewUiBinder uiBinder = GWT.create(DodajUslugeViewUiBinder.class);

	interface DodajUslugeViewUiBinder extends UiBinder<Widget, DodajUslugeView> {
	}

	interface Driver extends SimpleBeanEditorDriver<PozycjaDTO, DodajUslugeView> {
	}

	Driver driver = GWT.create(Driver.class);
	private ValidatorFactory factory = Validation.byDefaultProvider().configure().buildValidatorFactory();
	Validator validator = this.factory.getValidator();

	@UiField
	@Path("nazwa")
	TextBox textBoxNazwa;

	@UiField
	@Path("uslugaDTO.cenaZaGodzine")
	DoubleBox doubleBoxCenaZaGodzine;

	@UiField
	@Path("vat")
	DoubleBox doubleBoxVAT;

	@UiField
	Button buttonDodaj;

	@UiField
	@Ignore
	Label errorLabel;

	private DodajUslugePresenter presenter;

	public DodajUslugeView() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		doubleBoxVAT.setEnabled(false);
		driver.edit(new PozycjaDTO(null, 23.0, new UslugaDTO(null)));
		ustawPlaceHoldery();
		AppResources.INSTANCE.style().ensureInjected();
	}

	private void ustawPlaceHoldery() {
		textBoxNazwa.getElement().setPropertyString("placeholder", "Nazwa");
		doubleBoxCenaZaGodzine.getElement().setPropertyString("placeholder", "0.0");
	}

	public PozycjaDTO odbierzZawartoscTextBoxow() {

		PozycjaDTO pozycjaDTO = driver.flush();

		return pozycjaDTO;
	}

	@Override
	public void setPresenter(DodajUslugePresenter presenter) {
		this.presenter = presenter;

	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		if (waliduj()) {
			presenter.onDodajUslugeButtonClicked();
			removeFromParent();
			driver.edit(new PozycjaDTO(null, 23.0, new UslugaDTO(null)));
		}

	}

	private boolean waliduj() {
		PozycjaDTO pozycjaDTO = driver.flush();
		Set<ConstraintViolation<PozycjaDTO>> violations = validator.validate(pozycjaDTO);
		Set<ConstraintViolation<UslugaDTO>> violations2 = validator.validate(pozycjaDTO.getUslugaDTO());
		StringBuilder builder = new StringBuilder();
		for (ConstraintViolation<PozycjaDTO> violation : violations) {
			builder.append(violation.getMessage());
		}
		for (ConstraintViolation<UslugaDTO> violation : violations2) {
			builder.append(violation.getMessage());
		}

		errorLabel.setText(builder.toString());

		if (violations.isEmpty() && violations2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}

package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.MenuPresenter;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;
import rogalski.client.resources.AppResources;

public class MenuView extends Composite implements MenuDisplay {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	@UiTemplate("MenuView.ui.xml")
	interface MenuUiBinder extends UiBinder<Widget, MenuView> {
	}

	private MenuPresenter presenter;
	
	@UiField
	Button buttonWyswietlKlientow;

	@UiField
	Button buttonWyswietlFaktury;

	@UiField
	Button buttonDodajNowaFakture;

	@UiField
	Button buttonWyswietlPozycje;

	@UiField
	VerticalPanel verticalPanel;

	public MenuView() {
		initWidget(uiBinder.createAndBindUi(this));
		verticalPanel.getElement().setAttribute("align", "center");
		AppResources.INSTANCE.style().ensureInjected();
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@UiHandler("buttonWyswietlPozycje")
	void wyswietlPozycje(ClickEvent e) {
		presenter.onWyswietlPozycjeButtonClicked();
	}

	@UiHandler("buttonWyswietlKlientow")

	void wyswietlKlientow(ClickEvent e) {
		presenter.onWyswietlKlientowButtonClicked();
	}

	@UiHandler("buttonWyswietlFaktury")
	void wyswietlFaktury(ClickEvent e) {

		presenter.onWyswietlFakturyButtonClicked();
	}

	@UiHandler("buttonDodajNowaFakture")
	void dodajNowaFakture(ClickEvent e) {
		presenter.onDodajNowaFaktureButtonClicked();
	}

	@Override
	public void setPresenter(MenuPresenter presenter) {
		this.presenter = presenter;

	}

}

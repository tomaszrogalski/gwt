package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.HomePresenter;
import rogalski.client.presenter.HomePresenter.HomeDisplay;

public class HomeView extends Composite implements HomeDisplay {

	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}

	// MenuView panelMenu;
	@UiField
	HTMLPanel panelMenu;

	@UiField
	HTMLPanel htmlPanelRoboczy;

	@UiField
	Button buttonWyswietlKlientow;
	
	@UiField
	TextBox textBoxNazwa;

	private HomePresenter presenter;

	public HomeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public HTMLPanel getPanelMenu() {
		return panelMenu;
	}

	public HTMLPanel getHtmlPanelRoboczy() {
		return htmlPanelRoboczy;
	}

	@UiHandler("buttonWyswietlKlientow")

	void wyswietlKlientow(ClickEvent e) {
		if (presenter != null) {
			presenter.onWyswietlKlientowButtonClicked();
		} else {
			Window.alert("JEDNAK JEST NULL");
		}
	}

	@Override
	public void setPresenter(HomePresenter presenter) {
		this.presenter = presenter;

	}

}

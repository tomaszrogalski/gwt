package rogalski.client.view;

import com.google.gwt.core.client.GWT;
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

	@UiField
	HTMLPanel panelMenu;

	@UiField
	HTMLPanel htmlPanelRoboczy;

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

	@Override
	public void setPresenter(HomePresenter presenter) {
		this.presenter = presenter;

	}

}

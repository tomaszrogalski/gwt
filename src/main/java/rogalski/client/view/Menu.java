package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	interface MenuUiBinder extends UiBinder<Widget, MenuView> {
	}
	
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

	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

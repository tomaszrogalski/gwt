package rogalski.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle  {
	public static final AppResources INSTANCE =  GWT.create(AppResources.class);

	interface Normalize extends CssResource {
	}

	interface Style extends CssResource {

		String valueListBox();

		String menu_html_Panel();

		String menu_button_rozmiary();

		String menu_vertical_panel();

		String wyswietl_html_panel();

		String label();

		String error_page();

		String dodaj_html_panel();

		String horizontal_panel_buttony();

		String home_html_panel_glowny();

		String home_html_panel_menu();

		String home_html_panel_roboczy();

		String dodaj_horizontal_panel();

		String buttony_wyswietl_dodaj();

		String errorLabel();
	}

	@Source("css/style.css")
	public Style style();
}

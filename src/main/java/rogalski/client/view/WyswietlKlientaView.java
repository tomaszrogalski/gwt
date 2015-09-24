package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.WyswietlKlientowPresenter.WyswietlKlientaDisplay;

public class WyswietlKlientaView extends Composite implements WyswietlKlientaDisplay {

	private static WyswietlKlientaViewUiBinder uiBinder = GWT.create(WyswietlKlientaViewUiBinder.class);

	interface WyswietlKlientaViewUiBinder extends UiBinder<Widget, WyswietlKlientowView> {
	}

	public WyswietlKlientaView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public Widget asWidget() {
		return this;
	}

}

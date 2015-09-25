package rogalski.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.ErrorPresenter;
import rogalski.client.presenter.ErrorPresenter.ErrorDisplay;
import rogalski.client.presenter.MenuPresenter.MenuDisplay;
import rogalski.client.resources.AppResources;

public class ErrorView extends Composite implements ErrorDisplay{

	private static ErrorViewUiBinder uiBinder = GWT.create(ErrorViewUiBinder.class);

	interface ErrorViewUiBinder extends UiBinder<Widget, ErrorView> {
	}

	ErrorPresenter presenter;
	public ErrorView() {
		initWidget(uiBinder.createAndBindUi(this));
		AppResources.INSTANCE.style().ensureInjected();
	}
	@Override
	public void setPresenter(ErrorPresenter presenter) {
		this.presenter = presenter;

	}


}

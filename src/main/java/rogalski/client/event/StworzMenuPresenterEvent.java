package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;

public class StworzMenuPresenterEvent extends GwtEvent<StworzMenuPresenterEvent.StworzMenuPresenterHandler> {
	public static Type<StworzMenuPresenterHandler> TYPE = new Type<StworzMenuPresenterHandler>();

	public interface StworzMenuPresenterHandler extends EventHandler {
		void onStworzMenuPresenter(StworzMenuPresenterEvent event);
	}
	
	public StworzMenuPresenterEvent() {
		
	}

	public static Type<StworzMenuPresenterHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final StworzMenuPresenterHandler handler) {
		handler.onStworzMenuPresenter(this);
	}

	@Override
	public Type<StworzMenuPresenterHandler> getAssociatedType() {
		return TYPE;
	}

}

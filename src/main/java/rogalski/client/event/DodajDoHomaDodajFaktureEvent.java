package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoHomaDodajFaktureEvent
		extends GwtEvent<DodajDoHomaDodajFaktureEvent.DodajDoHomaDodajFaktureHandler> {
	private static Type<DodajDoHomaDodajFaktureHandler> TYPE = new Type<DodajDoHomaDodajFaktureHandler>();

	public interface DodajDoHomaDodajFaktureHandler extends EventHandler {
		void onDodajDoHomaDodajFakture(DodajDoHomaDodajFaktureEvent event);
	}

	public static Type<DodajDoHomaDodajFaktureHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoHomaDodajFaktureHandler handler) {
		handler.onDodajDoHomaDodajFakture(this);
	}

	@Override
	public Type<DodajDoHomaDodajFaktureHandler> getAssociatedType() {
		return TYPE;
	}

}

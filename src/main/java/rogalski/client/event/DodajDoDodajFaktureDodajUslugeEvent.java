package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoDodajFaktureDodajUslugeEvent
		extends GwtEvent<DodajDoDodajFaktureDodajUslugeEvent.DodajDoDodajFaktureDodajUslugeHandler> {
	private static Type<DodajDoDodajFaktureDodajUslugeHandler> TYPE = new Type<DodajDoDodajFaktureDodajUslugeHandler>();

	public interface DodajDoDodajFaktureDodajUslugeHandler extends EventHandler {
		void onDodajDoDodajFaktureDodajUsluge(DodajDoDodajFaktureDodajUslugeEvent event);
	}

	public static Type<DodajDoDodajFaktureDodajUslugeHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoDodajFaktureDodajUslugeHandler handler) {
		handler.onDodajDoDodajFaktureDodajUsluge(this);
	}

	@Override
	public Type<DodajDoDodajFaktureDodajUslugeHandler> getAssociatedType() {
		return TYPE;
	}

}

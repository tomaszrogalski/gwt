package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoDodajFaktureDodajProduktEvent
		extends GwtEvent<DodajDoDodajFaktureDodajProduktEvent.DodajDoDodajFaktureDodajProduktHandler> {
	private static Type<DodajDoDodajFaktureDodajProduktHandler> TYPE = new Type<DodajDoDodajFaktureDodajProduktHandler>();

	public interface DodajDoDodajFaktureDodajProduktHandler extends EventHandler {
		void onDodajDoDodajFaktureDodajProdukt(DodajDoDodajFaktureDodajProduktEvent event);
	}

	public static Type<DodajDoDodajFaktureDodajProduktHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoDodajFaktureDodajProduktHandler handler) {
		handler.onDodajDoDodajFaktureDodajProdukt(this);
	}

	@Override
	public Type<DodajDoDodajFaktureDodajProduktHandler> getAssociatedType() {
		return TYPE;
	}

}

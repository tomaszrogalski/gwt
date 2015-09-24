package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoHomaWyswietlKlientowEvent
		extends GwtEvent<DodajDoHomaWyswietlKlientowEvent.DodajDoHomaWyswietlKlientowHandler> {
	public static Type<DodajDoHomaWyswietlKlientowHandler> TYPE = new Type<DodajDoHomaWyswietlKlientowHandler>();

	public interface DodajDoHomaWyswietlKlientowHandler extends EventHandler {
		void onDodajDoHomaWyswietlKlientow(DodajDoHomaWyswietlKlientowEvent event);
	}

	public static Type<DodajDoHomaWyswietlKlientowHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoHomaWyswietlKlientowHandler handler) {
		handler.onDodajDoHomaWyswietlKlientow(this);
	}

	@Override
	public Type<DodajDoHomaWyswietlKlientowHandler> getAssociatedType() {
		return TYPE;
	}

}

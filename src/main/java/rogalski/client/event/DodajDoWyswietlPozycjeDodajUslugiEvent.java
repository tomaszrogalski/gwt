package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoWyswietlPozycjeDodajUslugiEvent
		extends GwtEvent<DodajDoWyswietlPozycjeDodajUslugiEvent.DodajDoWyswietlPozycjeDodajUslugiHandler> {
	private static Type<DodajDoWyswietlPozycjeDodajUslugiHandler> TYPE = new Type<DodajDoWyswietlPozycjeDodajUslugiHandler>();

	public interface DodajDoWyswietlPozycjeDodajUslugiHandler extends EventHandler {
		void onDodajDoWyswietlPozycjeDodajUslugi(DodajDoWyswietlPozycjeDodajUslugiEvent event);
	}

	public static Type<DodajDoWyswietlPozycjeDodajUslugiHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoWyswietlPozycjeDodajUslugiHandler handler) {
		handler.onDodajDoWyswietlPozycjeDodajUslugi(this);
	}

	@Override
	public Type<DodajDoWyswietlPozycjeDodajUslugiHandler> getAssociatedType() {
		return TYPE;
	}

}

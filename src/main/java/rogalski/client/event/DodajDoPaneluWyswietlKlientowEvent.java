package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

public class DodajDoPaneluWyswietlKlientowEvent
		extends GwtEvent<DodajDoPaneluWyswietlKlientowEvent.DodajDoPaneluWyswietlKlientowHandler> {
	public static Type<DodajDoPaneluWyswietlKlientowHandler> TYPE = new Type<DodajDoPaneluWyswietlKlientowHandler>();

	public interface DodajDoPaneluWyswietlKlientowHandler extends EventHandler {
		void onDodajDoPaneluWyswietlKlientow(DodajDoPaneluWyswietlKlientowEvent event);
	}

	public DodajDoPaneluWyswietlKlientowEvent() {
		Window.alert("W evencieee");
		
	}

	public static Type<DodajDoPaneluWyswietlKlientowHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDoPaneluWyswietlKlientowHandler handler) {
		handler.onDodajDoPaneluWyswietlKlientow(this);
	}

	@Override
	public Type<DodajDoPaneluWyswietlKlientowHandler> getAssociatedType() {
		return TYPE;
	}

}

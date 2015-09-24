package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajOstatnioDodanaFaktureDoWyswietleniaEvent extends
		GwtEvent<DodajOstatnioDodanaFaktureDoWyswietleniaEvent.DodajOstatnioDodanaFaktureDoWyswietleniaHandler> {
	private static Type<DodajOstatnioDodanaFaktureDoWyswietleniaHandler> TYPE = new Type<DodajOstatnioDodanaFaktureDoWyswietleniaHandler>();

	public interface DodajOstatnioDodanaFaktureDoWyswietleniaHandler extends EventHandler {
		void onDodajOstatnioDodanaFaktureDoWyswietlenia(DodajOstatnioDodanaFaktureDoWyswietleniaEvent event);
	}

	public static Type<DodajOstatnioDodanaFaktureDoWyswietleniaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajOstatnioDodanaFaktureDoWyswietleniaHandler handler) {
		handler.onDodajOstatnioDodanaFaktureDoWyswietlenia(this);
	}

	@Override
	public Type<DodajOstatnioDodanaFaktureDoWyswietleniaHandler> getAssociatedType() {
		return TYPE;
	}

}

package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import rogalski.shared.dto.PozycjaDTO;

public class DodajOstatnioDodanaPozycjeDoWyswietleniaEvent extends
		GwtEvent<DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.DodajOstatnioDodanaPozycjeDoWyswietleniaHandler> {
	private static Type<DodajOstatnioDodanaPozycjeDoWyswietleniaHandler> TYPE = new Type<DodajOstatnioDodanaPozycjeDoWyswietleniaHandler>();

	public interface DodajOstatnioDodanaPozycjeDoWyswietleniaHandler extends EventHandler {
		void onDodajOstatnioDodanaPozycjeDoWyswietlenia(DodajOstatnioDodanaPozycjeDoWyswietleniaEvent event);
	}

	PozycjaDTO pozycjaDTO;

	public DodajOstatnioDodanaPozycjeDoWyswietleniaEvent(PozycjaDTO pozycjaDTO) {
		this.pozycjaDTO = pozycjaDTO;
	}

	public static void fire(HasHandlers source, PozycjaDTO pozycjaDTO) {
		source.fireEvent(new DodajOstatnioDodanaPozycjeDoWyswietleniaEvent(pozycjaDTO));
	}

	public static Type<DodajOstatnioDodanaPozycjeDoWyswietleniaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajOstatnioDodanaPozycjeDoWyswietleniaHandler handler) {
		handler.onDodajOstatnioDodanaPozycjeDoWyswietlenia(this);
	}

	@Override
	public Type<DodajOstatnioDodanaPozycjeDoWyswietleniaHandler> getAssociatedType() {
		return TYPE;
	}

	public PozycjaDTO getPozycjaDTO() {
		return pozycjaDTO;
	}
}

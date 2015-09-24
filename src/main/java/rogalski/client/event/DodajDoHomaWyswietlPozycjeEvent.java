package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoHomaWyswietlPozycjeEvent extends GwtEvent<DodajDoHomaWyswietlPozycjeEvent.DodajDoHomaWyswietlPozycjeHandler> {
    private static Type<DodajDoHomaWyswietlPozycjeHandler> TYPE = new Type<DodajDoHomaWyswietlPozycjeHandler>();
    
    public interface DodajDoHomaWyswietlPozycjeHandler extends EventHandler {
        void onDodajDoHomaWyswietlPozycje(DodajDoHomaWyswietlPozycjeEvent event);
    }


    public static Type<DodajDoHomaWyswietlPozycjeHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DodajDoHomaWyswietlPozycjeHandler handler) {
        handler.onDodajDoHomaWyswietlPozycje(this);
    }

    @Override
    public Type<DodajDoHomaWyswietlPozycjeHandler> getAssociatedType() {
        return TYPE;
    }

}
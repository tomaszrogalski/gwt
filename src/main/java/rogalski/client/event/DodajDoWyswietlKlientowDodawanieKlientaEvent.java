package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoWyswietlKlientowDodawanieKlientaEvent extends GwtEvent<DodajDoWyswietlKlientowDodawanieKlientaEvent.DodajDoWyswietlKlientowDodawanieKlientaHandler> {
    private static Type<DodajDoWyswietlKlientowDodawanieKlientaHandler> TYPE = new Type<DodajDoWyswietlKlientowDodawanieKlientaHandler>();
    
    public interface DodajDoWyswietlKlientowDodawanieKlientaHandler extends EventHandler {
        void onDodajDoWyswietlKlientowDodawanieKlienta(DodajDoWyswietlKlientowDodawanieKlientaEvent event);
    }

    public static Type<DodajDoWyswietlKlientowDodawanieKlientaHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DodajDoWyswietlKlientowDodawanieKlientaHandler handler) {
        handler.onDodajDoWyswietlKlientowDodawanieKlienta(this);
    }

    @Override
    public Type<DodajDoWyswietlKlientowDodawanieKlientaHandler> getAssociatedType() {
        return TYPE;
    }

}
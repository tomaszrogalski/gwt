package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajOstatnioDodanegoKlientaDoWyswietleniaEvent extends GwtEvent<DodajOstatnioDodanegoKlientaDoWyswietleniaEvent.DodajOstatnioDodanegoKlientaDoWyswietleniaHandler> {
    private static Type<DodajOstatnioDodanegoKlientaDoWyswietleniaHandler> TYPE = new Type<DodajOstatnioDodanegoKlientaDoWyswietleniaHandler>();
    
    public interface DodajOstatnioDodanegoKlientaDoWyswietleniaHandler extends EventHandler {
        void onDodajOstatnioDodanegoKlientaDoWyswietlenia(DodajOstatnioDodanegoKlientaDoWyswietleniaEvent event);
    }

    public static Type<DodajOstatnioDodanegoKlientaDoWyswietleniaHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DodajOstatnioDodanegoKlientaDoWyswietleniaHandler handler) {
        handler.onDodajOstatnioDodanegoKlientaDoWyswietlenia(this);
    }

    @Override
    public Type<DodajOstatnioDodanegoKlientaDoWyswietleniaHandler> getAssociatedType() {
        return TYPE;
    }

}
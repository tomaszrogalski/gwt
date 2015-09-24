package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoHomaWyswietlFakturyEvent extends GwtEvent<DodajDoHomaWyswietlFakturyEvent.DodajDoHomaWyswietlFakturyHandler> {
    private static Type<DodajDoHomaWyswietlFakturyHandler> TYPE = new Type<DodajDoHomaWyswietlFakturyHandler>();
    
    public interface DodajDoHomaWyswietlFakturyHandler extends EventHandler {
        void onDodajDoHomaWyswietlFaktury(DodajDoHomaWyswietlFakturyEvent event);
    }


    public static Type<DodajDoHomaWyswietlFakturyHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DodajDoHomaWyswietlFakturyHandler handler) {
        handler.onDodajDoHomaWyswietlFaktury(this);
    }

    @Override
    public Type<DodajDoHomaWyswietlFakturyHandler> getAssociatedType() {
        return TYPE;
    }

}
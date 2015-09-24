package rogalski.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DodajDoWyswietlPozycjeDodajProduktEvent extends GwtEvent<DodajDoWyswietlPozycjeDodajProduktEvent.DodajDoWyswietlPozycjeDodajProduktHandler> {
    private static Type<DodajDoWyswietlPozycjeDodajProduktHandler> TYPE = new Type<DodajDoWyswietlPozycjeDodajProduktHandler>();
    
    public interface DodajDoWyswietlPozycjeDodajProduktHandler extends EventHandler {
        void onDodajDoWyswietlPozycjeDodajProdukt(DodajDoWyswietlPozycjeDodajProduktEvent event);
    }


    public static Type<DodajDoWyswietlPozycjeDodajProduktHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final DodajDoWyswietlPozycjeDodajProduktHandler handler) {
        handler.onDodajDoWyswietlPozycjeDodajProdukt(this);
    }

    @Override
    public Type<DodajDoWyswietlPozycjeDodajProduktHandler> getAssociatedType() {
        return TYPE;
    }

}
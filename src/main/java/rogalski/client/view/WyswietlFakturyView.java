package rogalski.client.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.cell.client.AbstractInputCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import rogalski.client.presenter.WyswietlFakturyPresenter.WyswietlFakturyDisplay;
import rogalski.shared.dto.FakturaDTO;
import rogalski.shared.dto.PozycjaDTO;

public class WyswietlFakturyView extends Composite implements WyswietlFakturyDisplay {

	private static WyswietlFakturyViewUiBinder uiBinder = GWT.create(WyswietlFakturyViewUiBinder.class);

	interface WyswietlFakturyViewUiBinder extends UiBinder<Widget, WyswietlFakturyView> {
	}

	@UiField
	DataGrid<FakturaDTO> dataGridWyswietlFaktury;

	public Widget asWidget() {
		return this;
	}

	public WyswietlFakturyView() {
		initWidget(uiBinder.createAndBindUi(this));
		stworzDataGrid();

	}

	private void stworzDataGrid() {
		TextColumn<FakturaDTO> textColumnNrFaktury = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getNrFaktury().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnKlientImie = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getKlientDTO().getImie().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnKlientNazwisko = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getKlientDTO().getNazwisko().toString();
			}

		};

		final DynamicSelectionCell listBoxZPozycjami = new DynamicSelectionCell(new ArrayList<String>());
		Column<FakturaDTO, String> columnListaPozycji = new Column<FakturaDTO, String>(listBoxZPozycjami) {

			@Override
			public String getValue(FakturaDTO object) {
				listBoxZPozycjami.usun();

				for (PozycjaDTO pozycjaDTO : object.getListaPozycjiDTO()) {
					listBoxZPozycjami.addOption(pozycjaDTO.toString());
				}
				return null;
			}
		};
		dataGridWyswietlFaktury.setWidth("100%");
		dataGridWyswietlFaktury.setHeight("300px");
		dataGridWyswietlFaktury.addColumn(textColumnNrFaktury, "NR FAKTURY");
		dataGridWyswietlFaktury.addColumn(textColumnKlientImie, "IMIE");
		dataGridWyswietlFaktury.addColumn(textColumnKlientNazwisko, "NAZWISKO");
		dataGridWyswietlFaktury.addColumn(columnListaPozycji, "LISTA POZYCJI");
		dataGridWyswietlFaktury.setColumnWidth(0, "10%");
		dataGridWyswietlFaktury.setColumnWidth(1, "20%");
		dataGridWyswietlFaktury.setColumnWidth(2, "20%");
		dataGridWyswietlFaktury.setColumnWidth(3, "50%");
	}

	public DataGrid<FakturaDTO> getDataGridWyswietlFaktury() {
		return dataGridWyswietlFaktury;
	}

}

// Zrodlo:
// http://stackoverflow.com/questions/4565790/how-to-dynamically-update-the-choices-in-a-selectioncell-using-gwt
class DynamicSelectionCell extends AbstractInputCell<String, String> {

	interface Template extends SafeHtmlTemplates {
		@Template("<option value=\"{0}\">{0}</option>")
		SafeHtml deselected(String option);

		@Template("<option value=\"{0}\" selected=\"selected\">{0}</option>")
		SafeHtml selected(String option);
	}

	private static Template template;

	private HashMap<String, Integer> indexForOption = new HashMap<String, Integer>();

	private List<String> options;

	/**
	 * Construct a new {@link SelectionCell} with the specified options.
	 *
	 * @param options
	 *            the options in the cell
	 */
	public DynamicSelectionCell(List<String> options) {
		super(BrowserEvents.CHANGE);
		if (template == null) {
			template = GWT.create(Template.class);
		}
		this.options = new ArrayList<String>(options);
		int index = 0;
		for (String option : options) {
			indexForOption.put(option, index++);
		}
	}

	public void addOption(String newOp) {
		String option = new String(newOp);
		options.add(option);
		refreshIndexes();
	}

	public void removeOption(String op) {
		String option = new String(op);
		options.remove(indexForOption.get(option));
		refreshIndexes();
	}

	private void refreshIndexes() {
		int index = 0;
		for (String option : options) {
			indexForOption.put(option, index++);
		}
	}

	public void usun() {
		options = new ArrayList<>();
	}

	@Override
	public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event,
			ValueUpdater<String> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		String type = event.getType();
		if (BrowserEvents.CHANGE.equals(type)) {
			Object key = context.getKey();
			SelectElement select = parent.getFirstChild().cast();
			String newValue = options.get(select.getSelectedIndex());
			setViewData(key, newValue);
			finishEditing(parent, newValue, key, valueUpdater);
			if (valueUpdater != null) {
				valueUpdater.update(newValue);
			}
		}
	}

	@Override
	public void render(Context context, String value, SafeHtmlBuilder sb) {
		// Get the view data.
		Object key = context.getKey();
		String viewData = getViewData(key);
		if (viewData != null && viewData.equals(value)) {
			clearViewData(key);
			viewData = null;
		}

		int selectedIndex = getSelectedIndex(viewData == null ? value : viewData);
		sb.appendHtmlConstant("<select tabindex=\"-1\">");
		int index = 0;
		for (String option : options) {
			if (index++ == selectedIndex) {
				sb.append(template.selected(option));
			} else {
				sb.append(template.deselected(option));
			}
		}
		sb.appendHtmlConstant("</select>");
	}

	private int getSelectedIndex(String value) {
		Integer index = indexForOption.get(value);
		if (index == null) {
			return -1;
		}
		return index.intValue();
	}
}

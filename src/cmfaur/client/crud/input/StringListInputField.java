package cmfaur.client.crud.input;

import java.util.List;



import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.StringListField;
import cmfaur.client.crud.widgets.StringListWidget;

import com.google.gwt.user.client.ui.Widget;

public class StringListInputField implements CrudInputField {

	private StringListWidget stringListWidget;
	private StringListField field;
	
	public StringListInputField(StringListField field) {
		this.field = field;
		stringListWidget = new StringListWidget((List<String>) field.getValue());
	}

	public CrudField getCrudField() {
		field.setValue(getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return stringListWidget;
	}

	public Object getValue() {
		return stringListWidget.getValue();
	}

	public void load(Object value) {
		stringListWidget.setValue((List<String>) value);
	}

}

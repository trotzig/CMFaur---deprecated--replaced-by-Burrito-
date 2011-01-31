package cmfaur.client.crud.input;


import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.LinkedEntityField;
import cmfaur.client.crud.widgets.LinkedEntityWidget;
import cmfaur.client.crud.widgets.LinkedEntityWidgetPopup;

import com.google.gwt.user.client.ui.Widget;

public class LinkedEntityInputField implements CrudInputField<String> {

	private LinkedEntityField field;
	private LinkedEntityWidget widget;

	public LinkedEntityInputField(LinkedEntityField field) {
		this.field = field;
		widget = new LinkedEntityWidget(field.isRequired(), false);
		load((String) field.getValue());
	}

	public CrudField getCrudField() {
		field.setValue(getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return widget;
	}

	public String getValue() {
		return widget.getValue();
	}

	public void load(String json) {
		widget.setValue(json);
	}

}

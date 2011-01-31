package cmfaur.client.crud.input;

import java.util.List;



import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.LinkListField;
import cmfaur.client.crud.widgets.LinkedEntityWidget;

import com.google.gwt.user.client.ui.Widget;

public class LinkListInputField implements CrudInputField<List<String>> {

	private LinkListField field;
	private LinkedEntityWidget widget;

	public LinkListInputField(LinkListField field) {
		this.field = field;
		widget = new LinkedEntityWidget(field.isRequired(), true);
		load((List<String>) field.getValue());
	}

	public CrudField getCrudField() {
		field.setValue(getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return widget;
	}

	public List<String> getValue() {
		return widget.getValues();
	}

	public void load(List<String> value) {
		widget.setValues(value);
	}

}

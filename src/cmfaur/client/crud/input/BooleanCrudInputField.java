package cmfaur.client.crud.input;

import java.util.List;



import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.BooleanField;
import cmfaur.client.crud.generic.fields.ManyToManyRelationField;
import cmfaur.client.crud.widgets.MultiValueListBox;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

public class BooleanCrudInputField implements CrudInputField {
	
	private BooleanField field;
	private CheckBox widget;

	public BooleanCrudInputField(BooleanField field) {
		this.field = field;
		this.widget = new CheckBox();
		if (field.getValue() != null) {
			widget.setValue((Boolean) field.getValue());
		}
	}

	public CrudField getCrudField() {
		field.setValue(widget.getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return widget;
	}

	public Object getValue() {
		return widget.getValue();
	}

	public void load(Object value) {
		widget.setValue((Boolean) value);
	}
}

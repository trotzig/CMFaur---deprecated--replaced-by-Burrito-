package cmfaur.client.crud.input;

import java.util.List;



import cmfaur.client.crud.generic.CrudEntityDescription;
import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.EmbeddedListField;
import cmfaur.client.crud.widgets.EmbeddedListWidget;

import com.google.gwt.user.client.ui.Widget;

public class EmbeddedListInputField implements CrudInputField<List<CrudEntityDescription>> {

	private EmbeddedListField field;
	private EmbeddedListWidget widget;

	public EmbeddedListInputField(EmbeddedListField field) {
		this.field = field;
		widget = new EmbeddedListWidget(field.getEmbeddedClassName(), field.isRequired());
		load((List<CrudEntityDescription>) field.getValue());
	}

	public CrudField getCrudField() {
		field.setValue(getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return widget;
	}

	public List<CrudEntityDescription> getValue() {
		return widget.getValue();
	}

	public void load(List<CrudEntityDescription> value) {
		widget.setValue(value);
	}

}

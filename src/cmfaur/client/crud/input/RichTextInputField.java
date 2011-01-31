package cmfaur.client.crud.input;


import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.RichTextField;
import cmfaur.client.crud.widgets.CrudRichTextArea;

import com.google.gwt.user.client.ui.Widget;

public class RichTextInputField implements CrudInputField<String> {

	private RichTextField field;
	private CrudRichTextArea area;
	
	
	
	public RichTextInputField(RichTextField field) {
		this.field = field;
		this.area = new CrudRichTextArea((String) field.getValue());
	}

	public CrudField getCrudField() {
		field.setValue(area.getValue());
		return field;
	}

	public Widget getDisplayWidget() {
		return area;
	}

	public String getValue() {
		return area.getValue();
	}

	public void load(String value) {
		area.setValue(value);
	}

}

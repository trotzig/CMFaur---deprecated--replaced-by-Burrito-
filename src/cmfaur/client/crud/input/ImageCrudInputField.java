package cmfaur.client.crud.input;


import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.ImageField;
import cmfaur.client.crud.widgets.ImagePicker;

import com.google.gwt.user.client.ui.Widget;

public class ImageCrudInputField implements CrudInputField {

	private ImageField crudField;
	private ImagePicker picker;
	
	public ImageCrudInputField(ImageField field) {
		picker = new ImagePicker(field.isRequired(), (String) field.getValue(), field.getWidth(), field.getHeight());
		crudField = field;
	}

	public CrudField getCrudField() {
		crudField.setValue(picker.getValue());
		return crudField;
	}

	public Widget getDisplayWidget() {
		return picker;
	}

	public Object getValue() {
		return picker.getValue();
	}

	public void load(Object value) {
		picker.setValue((String) value);
	}

}

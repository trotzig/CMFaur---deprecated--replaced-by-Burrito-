package cmfaur.client.crud.input;


import cmfaur.client.crud.generic.CrudField;

import com.google.gwt.user.client.ui.Widget;

public interface CrudInputField<T> {

	Widget getDisplayWidget();
	void load(T value);
	T getValue();
	CrudField getCrudField();
	
}

package cmfaur.client.crud.generic.fields;

import java.util.List;

import cmfaur.client.crud.generic.CrudField;



public class StringListField extends CrudField {

	private List<String> strings;
	
	public StringListField() {
		// Default constructor
	}
	
	public StringListField(List<String> strings) {
		this.strings = strings;
	}

	@Override
	public Class getType() {
		return List.class;
	}

	@Override
	public Object getValue() {
		return strings;
	}
	
	@Override
	public void setValue(Object value) {
		this.strings = (List<String>) value;
	}

}

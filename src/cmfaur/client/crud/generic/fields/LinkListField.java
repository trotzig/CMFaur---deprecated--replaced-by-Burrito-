package cmfaur.client.crud.generic.fields;

import java.util.List;

public class LinkListField extends StringListField {

	public LinkListField() {
		super();
	}
	
	public LinkListField(List<String> jsonLinks) {
		super(jsonLinks);
	}
	
}

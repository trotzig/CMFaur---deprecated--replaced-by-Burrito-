package cmfaur.client.crud.generic.fields;

import java.io.Serializable;
import java.util.List;

import cmfaur.client.crud.generic.CrudField;



/**
 * A {@link CrudField} representating an many-to-many relation
 * 
 * @author henper
 * 
 */
public class ManyToManyRelationField extends CrudField {

	private List<Long> list;
	private String relatedEntityName;

	public ManyToManyRelationField() {
		// default constructor
	}

	public ManyToManyRelationField(List<Long> list, String relatedEntityName) {
		this.list = list;
		this.relatedEntityName = relatedEntityName;
	}

	@Override
	public Class getType() {
		return List.class;
	}

	@Override
	public Object getValue() {
		return list;
	}

	@Override
	public void setValue(Object value) {
		this.list = (List<Long>) value;
	}

	/**
	 * The class name of the related entity
	 * 
	 * @return
	 */
	public String getRelatedEntityName() {
		return relatedEntityName;
	}

	public void setRelatedEntityClass(String relatedEntityName) {
		this.relatedEntityName = relatedEntityName;
	}

}

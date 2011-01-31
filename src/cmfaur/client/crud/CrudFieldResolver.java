package cmfaur.client.crud;

import java.util.Date;
import java.util.List;

import cmfaur.client.crud.generic.CrudField;
import cmfaur.client.crud.generic.fields.BooleanField;
import cmfaur.client.crud.generic.fields.DateField;
import cmfaur.client.crud.generic.fields.DisplayableMethodField;
import cmfaur.client.crud.generic.fields.EmbeddedListField;
import cmfaur.client.crud.generic.fields.EnumField;
import cmfaur.client.crud.generic.fields.ImageField;
import cmfaur.client.crud.generic.fields.LinkListField;
import cmfaur.client.crud.generic.fields.LinkedEntityField;
import cmfaur.client.crud.generic.fields.ManyToManyRelationField;
import cmfaur.client.crud.generic.fields.ManyToOneRelationField;
import cmfaur.client.crud.generic.fields.RichTextField;
import cmfaur.client.crud.generic.fields.StringField;
import cmfaur.client.crud.generic.fields.StringListField;
import cmfaur.client.crud.generic.fields.StringSelectionField;
import cmfaur.client.crud.input.BooleanCrudInputField;
import cmfaur.client.crud.input.CrudInputField;
import cmfaur.client.crud.input.CrudInputFieldImpl;
import cmfaur.client.crud.input.DateCrudInputField;
import cmfaur.client.crud.input.EmbeddedListInputField;
import cmfaur.client.crud.input.EnumSelectionListField;
import cmfaur.client.crud.input.ImageCrudInputField;
import cmfaur.client.crud.input.IntegerInputField;
import cmfaur.client.crud.input.LinkListInputField;
import cmfaur.client.crud.input.LinkedEntityInputField;
import cmfaur.client.crud.input.ListCrudInputField;
import cmfaur.client.crud.input.ReadOnlyTextCrudInputField;
import cmfaur.client.crud.input.RichTextInputField;
import cmfaur.client.crud.input.SelectionListField;
import cmfaur.client.crud.input.StringListInputField;
import cmfaur.client.crud.input.StringSelectionListField;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.kanal5.play.client.widgets.inputfield.LongInputField;
import com.kanal5.play.client.widgets.inputfield.StringInputField;
import com.kanal5.play.client.widgets.validation.InputFieldValidator;
import com.kanal5.play.client.widgets.validation.ValidationException;

/**
 * Utility class that knows how to translate a {@link CrudField} (which is a
 * description of an entity field) to a {@link CrudInputField} (which is a class
 * that decides which widget to use for user input)
 * 
 * @author henper
 * 
 */
public class CrudFieldResolver {

	public static class RegexpInputFieldValidator implements
			InputFieldValidator {

		private String regexpDescription;
		private String regexpPattern;

		public RegexpInputFieldValidator(String regexpPattern,
				String regexpDescription) {
			this.regexpPattern = regexpPattern;
			this.regexpDescription = regexpDescription;
		}

		public void validate(String value) throws ValidationException {
			if (!value.matches(regexpPattern)) {
				throw new ValidationException(regexpDescription);
			}
		}

	}

	/**
	 * Resolve and create an {@link CrudInputField} from a {@link CrudField}
	 * 
	 * @param field
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static CrudInputField createInputField(CrudField field, CrudServiceAsync service) {
		// First handle specific cases:
		if (field instanceof DisplayableMethodField) {
			//this field has no input
			return null;
		}
		
		
		if (field instanceof ManyToOneRelationField) {
			return new SelectionListField((ManyToOneRelationField) field, service);
		}
		if (field instanceof ImageField) {
			return new ImageCrudInputField((ImageField) field);
		}
		if (field instanceof RichTextField) {
			return new RichTextInputField((RichTextField) field);
		}
		if (field instanceof StringSelectionField) {
			return new StringSelectionListField((StringSelectionField) field);
		}
		if (field instanceof EnumField) {
			return new EnumSelectionListField((EnumField) field);
		}
		if (field instanceof LinkListField) {
			return new LinkListInputField((LinkListField) field);
		}
		if (field instanceof StringListField) {
			return new StringListInputField((StringListField) field);
		}
		if (field instanceof LinkedEntityField) {
			return new LinkedEntityInputField((LinkedEntityField) field);
		}
		if (field instanceof EmbeddedListField) {
			return new EmbeddedListInputField((EmbeddedListField) field);
		}
		
		

		// Fallback to raw type input:
		if (field.getType() == Date.class) {
			return new DateCrudInputField((DateField) field);
		}
		if (field.getType() == Long.class) {
			return new CrudInputFieldImpl<Long>(field, new LongInputField(field
					.isRequired()), (Long) field.getValue());
		}
		if (field.getType() == Integer.class) {
			return new CrudInputFieldImpl<Integer>(field,
					new IntegerInputField(field.isRequired()),
					(Integer) field.getValue());
		}
		if (field.getType() == String.class) {
			final StringField sf = (StringField) field;
			if (sf.isReadOnly()) {
				return new ReadOnlyTextCrudInputField(sf);
			}
			else {
				StringInputField stringInputField;
				if (sf.isRenderAsTextArea()) {
					stringInputField = new StringInputField(field.isRequired()) {
						@Override
						protected TextBoxBase createField() {
							return new TextArea();
						}
					};
				} else {
					stringInputField = new StringInputField(field.isRequired());
				}
				if (sf.getRegexpPattern() != null) {
					stringInputField
							.addInputFieldValidator(new RegexpInputFieldValidator(
									sf.getRegexpPattern(), sf
											.getRegexpDescription()));
				}
				return new CrudInputFieldImpl<String>(field, stringInputField,
						(String) field.getValue());
			}
		}
		if (field.getType() == Boolean.class) {
			return new BooleanCrudInputField((BooleanField) field);
		}
		if (field.getType() == List.class) {
			return new ListCrudInputField((ManyToManyRelationField) field);
		}
		return null;
	}

}

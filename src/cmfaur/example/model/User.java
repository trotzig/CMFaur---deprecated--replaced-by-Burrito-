package cmfaur.example.model;

import siena.Generator;
import siena.Id;
import siena.Model;
import cmfaur.annotations.Displayable;
import cmfaur.annotations.Link;
import cmfaur.annotations.Relation;
import cmfaur.annotations.SearchableField;
import cmfaur.links.Linkable;

public class User extends Model implements Linkable {

	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	@SearchableField
	@Displayable
	public String name;
	
	
	@Link
	public String friend;
	
	@Relation(User.class)
	public Long bff;

	@Override
	public String getUrl() {
		return "/users/" + name;
	}

	
	@Displayable
	public String getNameNormalized() {
		return name + "_norm";
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}

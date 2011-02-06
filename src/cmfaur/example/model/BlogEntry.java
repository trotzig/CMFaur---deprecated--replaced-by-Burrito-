package cmfaur.example.model;

import java.util.Date;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;
import cmfaur.annotations.Displayable;
import cmfaur.annotations.ReadOnly;
import cmfaur.annotations.Required;
import cmfaur.annotations.RichText;
import cmfaur.annotations.SearchableField;
import cmfaur.links.Linkable;
import cmfaur.util.StringUtils;

public class BlogEntry extends Model implements Linkable {

	@Id(Generator.AUTO_INCREMENT)
	private Long id;

	@SearchableField
	@Displayable
	@Required
	private String heading;
	
	@ReadOnly
	private Date created;
	
	@SearchableField
	@Required
	@RichText
	private String content;

	@Override
	public String getUrl() {
		return "/entry/" + StringUtils.makeSEOFriendly(heading) + "/" + id;
	}
	
	public static Query<BlogEntry> all() {
		return Model.all(BlogEntry.class);
	}
	
	public String getQuote() {
		return StringUtils.cut(StringUtils.stripHTML(content), 100);
	}
	
	@Override
	public void insert() {
		this.created = new Date();
		super.insert();
	}

	public Long getId() {
		return id;
	}

	public String getHeading() {
		return heading;
	}

	public Date getCreated() {
		return created;
	}

	public String getContent() {
		return content;
	}
	
	
	
		
}

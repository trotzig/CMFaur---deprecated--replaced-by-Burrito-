package cmfaur.example;

import mvcaur.Controller;
import cmfaur.example.model.BlogEntry;

public class BlogEntryController implements Controller<BlogEntry> {

	private Long id;
	
	@Override
	public BlogEntry execute() {
		return BlogEntry.all().filter("id", id).get();
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

}

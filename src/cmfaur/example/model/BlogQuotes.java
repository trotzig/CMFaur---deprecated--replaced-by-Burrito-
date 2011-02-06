package cmfaur.example.model;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import cmfaur.annotations.Required;
import cmfaur.sitelet.Sitelet;

public class BlogQuotes extends Model implements Sitelet {
	@Id(Generator.AUTO_INCREMENT)
    private Long id;
		
	@Required
	private Integer max = 5;
	
	public List<BlogEntry> getEntries() {
		return BlogEntry.all().order("-created").fetch(max);
	}
}

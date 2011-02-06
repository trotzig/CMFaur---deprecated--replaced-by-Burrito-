package cmfaur.example;

import cmfaur.example.model.BlogQuotes;
import cmfaur.example.model.BlogEntry;

public class Configurator extends cmfaur.Configurator {

	@Override
	protected void init() {
		addCrudable(BlogEntry.class);
		addLinkable(BlogEntry.class);
		addSitelet(BlogQuotes.class);
	}
	
}

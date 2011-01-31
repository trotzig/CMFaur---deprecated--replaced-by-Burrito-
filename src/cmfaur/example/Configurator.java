package cmfaur.example;

import cmfaur.example.model.HelloWorldSitelet;
import cmfaur.example.model.User;

public class Configurator extends cmfaur.Configurator {

	@Override
	protected void init() {
		addCrudable(User.class);
		addLinkable(User.class);
		addSitelet(HelloWorldSitelet.class);
	}
	
}

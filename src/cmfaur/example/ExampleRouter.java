package cmfaur.example;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import mvcaur.Router;

public class ExampleRouter extends Router {

	@Override
	public void init() {
		route("/").through(StartPageController.class).renderedBy("start.jsp");
	}
	
	@Override
	public boolean isUserAdmin() {
		UserService service = UserServiceFactory.getUserService();
		if (!service.isUserLoggedIn()) {
			return false;
		}
		return service.isUserAdmin();
	}

}

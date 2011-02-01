package cmfaur;

import mvcaur.Router;
import cmfaur.controller.AdminController;
import cmfaur.controller.VoidController;
import cmfaur.services.CrudServiceImpl;
import cmfaur.services.SiteletServiceImpl;

public class AdminRouter extends Router {

	@Override
	public void init() {
		route("/admin").through(AdminController.class).renderedBy("/Admin.jsp");
		route("/cmfaur/crudmessages.js").through(MessagesController.class).renderedBy(new MessagesRenderer());
		route("/cmfaur/siteletadmin.css").through(VoidController.class).renderedBy(new SiteletAdminCSSRenderer());
		route("/cmfaur/crud").throughServlet(CrudServiceImpl.class);
		route("/cmfaur/sitelets").throughServlet(SiteletServiceImpl.class);
	}
	

}

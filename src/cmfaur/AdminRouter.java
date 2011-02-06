package cmfaur;

import mvcaur.Router;
import cmfaur.controller.AdminController;
import cmfaur.controller.VoidController;
import cmfaur.render.MessagesRenderer;
import cmfaur.render.SiteletAdminCSSRenderer;
import cmfaur.services.CrudServiceImpl;
import cmfaur.services.SiteletServiceImpl;

import com.kanal5.play.server.blobstore.BlobServiceImpl;
import com.kanal5.play.server.blobstore.BlobStoreServlet;

public class AdminRouter extends Router {

	@Override
	public void init() {
		route("/admin").through(AdminController.class).renderedBy("/Admin.jsp");
		route("/cmfaur/crudmessages.js").through(MessagesController.class).renderedBy(new MessagesRenderer());
		route("/cmfaur/siteletadmin.css").through(VoidController.class).renderedBy(new SiteletAdminCSSRenderer());
		route("/cmfaur/crud").throughServlet(CrudServiceImpl.class);
		route("/cmfaur/sitelets").throughServlet(SiteletServiceImpl.class);
		route("/cmfaur/blobService").throughServlet(BlobServiceImpl.class);
		route("/blobstore/image").throughServlet(BlobStoreServlet.class);
	}
	

}

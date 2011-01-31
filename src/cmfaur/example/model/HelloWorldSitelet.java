package cmfaur.example.model;

import siena.Generator;
import siena.Id;
import siena.Model;
import cmfaur.annotations.Required;
import cmfaur.annotations.RichText;
import cmfaur.sitelet.Sitelet;

public class HelloWorldSitelet extends Model implements Sitelet {
	@Id(Generator.AUTO_INCREMENT)
    public Long id;
	
	@Required
	public String message;
	
	@RichText
	public String html;
	
	public String getMessage() {
		return message;
	}
	
	public String getHtml() {
		return html;
	}
}

package cmfaur.example.model;

import siena.Generator;
import siena.Id;
import siena.Model;
import cmfaur.sitelet.Sitelet;

public class HelloWorldSitelet extends Model implements Sitelet {
	@Id(Generator.AUTO_INCREMENT)
    public Long id;
	
	public String message;
}

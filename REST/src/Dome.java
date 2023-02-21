import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Path("/dome")
/*
 * Endpoint: http://localhost:8080/REST/rest/dome
 * REST: Root context
 * rest: url-pattern mapping defined in web.xml
 * dome: path to this class
 */
public class Dome {
	private ArrayList<CD> database;
	public Dome() {
		database = new ArrayList<CD>();
	}
	
	@POST
	@Path("{title},{artist}")
	public Response addCD(@PathParam("title")String title, @PathParam("artist")String artist) {
		database.add(new CD(title,artist));
		System.out.println("Title: " + title);
		System.out.println("Artist: " + artist);
		return Response.status(200).build(); 
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	public String getCD(@QueryParam("title")String title) {
		for (CD cd : database) {
			if (cd.getTitle().equals(title)) {
				System.out.println(cd.getTitle() + " " + cd.getArtist());
				return cd.getTitle() + " " + cd.getArtist(); 
			}
		}
		System.out.println("CD not exists");
		return "";
	}
	@GET
	@Path("/xml")
	@Produces("application/xml")	
	public CD getXmlCD(@QueryParam("title")String title) {
		for (CD cd : database) {
			if (cd.getTitle().equals(title)) {
				System.out.println(cd.getTitle() + " " + cd.getArtist());
				return cd; 
			}
		}
		System.out.println("CD not exists");
		return new CD("","");
	}
	@GET
	@Path("/json")
	@Produces("application/json")	
	public String getJsonCD(@QueryParam("title")String title) {
		Gson gson = new Gson();
		for (CD cd : database) {
			if (cd.getTitle().equals(title)) {
				System.out.println(cd.getTitle() + " " + cd.getArtist());				
				return gson.toJson(cd);				 
			}
		}
		System.out.println("CD not exists");
		return gson.toJson(new CD("",""));
	}	

}




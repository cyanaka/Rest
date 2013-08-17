package webService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.AccessManager;

import com.google.gson.Gson;

import dto.Location;

@Path("/locationService")
public class LocationService
{
	@GET
	@Path("/locationExists")
	@Produces(MediaType.APPLICATION_JSON)
	public String locationExists(@QueryParam("search") String search)
	{
		Location result = new Location();
		String resultString ="";
		try
		{
			String[] words = new String[3];
	        words = search.split("\\,");
	        Location l = new Location();
	        
	        l.setLogin(words[0]);
	        l.setLatitude(Double.parseDouble(words[1]));
	        l.setLongitude(Double.parseDouble(words[2]));
	        
			result = new AccessManager().locationExist(l);
			Gson gson = new Gson();
			resultString = gson.toJson(result);
			
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return resultString;
	}
	
	@POST
	@Path("/locationInsert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response locationInsert(Location location){
		String result = "false";
		try {
			result = new AccessManager().locationInsert(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return Response.status(201).entity(result).build();
		
	}
	
	@POST
	@Path("/locationUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response locationUpdate(Location location){
		String result = "false";
		try {
			result = new AccessManager().locationUpdate(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(201).entity(result).build();
	}
	
	

	
	
	
}

package webService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.AccessManager;
import dto.Location;

@Path("/locationService")
public class LocationService
{
	
	@GET
	@Path("/locationExists/{login}/{latitude}/{longitude}")
	@Produces(MediaType.APPLICATION_JSON)
	public Location locationExists(@PathParam("login") String login, @PathParam("latitude")Double latitude, @PathParam("longitude")Double longitude){
		
		Location result = new Location();
		
		Location location = new Location();
		location.setLogin(login);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		
		try {
			result = new AccessManager().locationExist(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
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

package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Access;
import dao.Database;
import dto.Course;
import dto.Location;

public class AccessManager
{
	public ArrayList<Course> getCourses() throws Exception
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		courseList = access.getCourses(con);
		return courseList;
	}

	public Location locationExist(Location l) throws Exception {
		
		Location result = new Location();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		result = access.locationExists(con, l);
		
		return result;
	}

	public String locationInsert(Location location) throws Exception {
		
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		String result = access.locationInsert(con, location);
		return result;
	}

	public String locationUpdate(Location location) throws Exception {
		
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		String result = access.locationUpdate(con, location);
		return result;
	}
}

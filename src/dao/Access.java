package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import dto.Course;
import dto.Location;

public class Access {
	public ArrayList<Course> getCourses(Connection con) throws SQLException {
		ArrayList<Course> courseList = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM course");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Course courseObj = new Course();
				courseObj.setId(rs.getInt("id"));
				courseObj.setName(rs.getString("name"));
				courseObj.setDuration(rs.getString("duration"));
				courseObj.setFee(rs.getDouble("fee"));
				courseList.add(courseObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;

	}

	public Location locationExists(Connection con, Location l)
			throws SQLException {

		Location result = new Location();

		try {
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM location l where l.login = '"
							+ l.getLogin()
							+ "' and l.latitude = '"
							+ l.getLatitude()
							+ "' and l.longitude='"
							+ l.getLongitude() + "'");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setLogin(rs.getString("login"));
				result.setLatitude(rs.getDouble("latitude"));
				result.setLongitude(rs.getDouble("longitude"));
				result.setDateTime(rs.getTimestamp("datetime"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String locationInsert(Connection con, Location location) {

		String result = "";
		int i = 0;
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO location (login, latitude, longitude, datetime)values(?,?,?,?)");
			stmt.setString(1, location.getLogin());
			stmt.setDouble(2, location.getLatitude());
			stmt.setDouble(3, location.getLongitude());
			Calendar cal = Calendar.getInstance();
			stmt.setDate(4, new java.sql.Date(cal.getTimeInMillis()));
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			result = "true";
		}else{
			result = "false";
		}
		return result;
	}

	public String locationUpdate(Connection con, Location location) {
		String result= "false";
		int i = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE  location SET datetime = ? WHERE id = ?");
			Calendar cal = Calendar.getInstance();
			stmt.setDate(1, new java.sql.Date(cal.getTimeInMillis()));
			stmt.setInt(2, location.getId());
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			result = "true";
		}else{
			result = "false";
		}
		
		
		return result;
	}
}

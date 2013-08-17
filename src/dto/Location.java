package dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Location {

	private int id;
	private String login;
	private Double latitude;
	private Double longitude;
	private Date dateTime;

	public Location() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", login=" + login + ", latitude="
				+ latitude + ", longitude=" + longitude + ", dateTime="
				+ dateTime + "]";
	}

}

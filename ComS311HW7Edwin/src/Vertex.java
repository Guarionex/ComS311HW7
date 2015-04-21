
public class Vertex {

	private int ID;
	private double longitude;
	private double latitude;
	
	
	Vertex(int ID, double longitude, double latitude)
	{
		this.ID = ID;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	int getID()
	{
		return ID;
	}
	
	double getLongitude()
	{
		return longitude;
	}
	
	double getLatitude()
	{
		return latitude;
	}
	
}

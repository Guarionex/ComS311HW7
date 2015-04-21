
public class Vertex {

	int ID;
	double longitude;
	double latitude;
	
	
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

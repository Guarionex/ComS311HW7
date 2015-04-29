
public class Vertex {

	private int ID;
	private double longitude;
	private double latitude;
	
	
	public Vertex(int ID, double latitude, double longitude)
	{
		this.ID = ID;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
}

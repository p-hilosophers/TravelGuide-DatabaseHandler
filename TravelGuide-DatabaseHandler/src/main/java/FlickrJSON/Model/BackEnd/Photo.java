package FlickrJSON.Model.BackEnd;


public class Photo {

    private String name;

    private double longitude;

    private double latitude;

    private String image;


    public Photo(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Photo(String name, double longitude, double latitude,String imageUrl) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = imageUrl;
    }
}

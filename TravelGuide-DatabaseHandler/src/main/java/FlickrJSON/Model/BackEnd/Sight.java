package FlickrJSON.Model.BackEnd;


public class Sight {

    private String name;

    private double longitude;

    private double latitude;

    private String photoCount;

    public Sight(){}

    public Sight(String name, double longitude, double latitude,String photoCount) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.photoCount = photoCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(String photoCount) {
        this.photoCount = photoCount;
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

}

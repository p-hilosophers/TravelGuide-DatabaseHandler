package FlickrJSON.Model.BackEnd;


public class Sight {

    private String name;

    private double longitude;

    private double latitude;

    private String season;

    private int photoCount;

    public Sight(){}

    public Sight(String name, double longitude, double latitude, String season, int photoCount) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.season = season;
        this.photoCount = photoCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}

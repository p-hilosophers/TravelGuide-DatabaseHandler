package FlickrJSON;

import java.io.Serializable;

public class PhotoGeoLoc implements Serializable {
    private String id;
    private String latitude;
    private String longitude;
    private String imgUrl;

    public PhotoGeoLoc(String latitude, String longitude, String id ,String imgUrl) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

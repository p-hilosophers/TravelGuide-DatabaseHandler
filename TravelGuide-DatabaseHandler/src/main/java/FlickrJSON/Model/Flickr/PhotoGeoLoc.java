package FlickrJSON.Model.Flickr;

import java.io.Serializable;

public class PhotoGeoLoc implements Serializable {
    private String id;
    private String latitude;
    private String longitude;
    private String imgUrl;
    private String date;
    private String season;
    private String dayNight;

    public PhotoGeoLoc(String latitude, String longitude, String id, String imgUrl, String date, String season, String dayNight) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgUrl = imgUrl;
        this.date = date;
        this.season = season;
        this.dayNight = dayNight;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
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

    public String getDayNight() {
        return dayNight;
    }

    public void setId(String id) {
        this.id = id;
    }
}

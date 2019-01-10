package FlickrJSON.Model.Flickr;

import java.io.Serializable;
import java.util.List;

public class Region implements Serializable {
    private String name;
    private String regionId;
    private int countPhoto;
    private String latitude;
    private String longitude;
    private String season;
    private String dayNight;
    private List<PhotoGeoLoc> photoGeoLocList;

    public Region(String name, String regionId, int countPhoto, String latitude, String longitude, String season, String dayNight, List<PhotoGeoLoc> photoGeoLocList) {
        this.name = name;
        this.regionId = regionId;
        this.countPhoto = countPhoto;
        this.latitude = latitude;
        this.longitude = longitude;
        this.season = season;
        this.dayNight = dayNight;
        this.photoGeoLocList = photoGeoLocList;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
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

    public int getCountPhoto() {
        return countPhoto;
    }

    public void setCountPhoto(int countPhoto) {
        this.countPhoto = countPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public List<PhotoGeoLoc> getPhotoGeoLocList() {
        return photoGeoLocList;
    }

    public void setPhotoGeoLocList(List<PhotoGeoLoc> photoGeoLocList) {
        this.photoGeoLocList = photoGeoLocList;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }
}

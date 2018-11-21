package FlickrJSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Region implements Serializable {
    private String name;
    private String regionId;
    private String countPhoto;
    private List<PhotoGeoLoc> photoGeoLocList;

    public Region(String name, String regionId, String countPhoto, List<PhotoGeoLoc> photoGeoLocList) {
        this.name = name;
        this.regionId = regionId;
        this.countPhoto = countPhoto;
        this.photoGeoLocList = photoGeoLocList;
    }

    public String getCountPhoto() {
        return countPhoto;
    }

    public void setCountPhoto(String countPhoto) {
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
}

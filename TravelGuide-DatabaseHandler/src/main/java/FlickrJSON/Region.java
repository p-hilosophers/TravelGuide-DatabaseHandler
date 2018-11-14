package FlickrJSON;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name = "";
    private String regionId = "";
    private List<PhotoGeoLoc> photoGeoLocList = new ArrayList<>();

    public Region(String name, String regionId, List<PhotoGeoLoc> photoGeoLocList) {
        this.name = name;
        this.regionId = regionId;
        this.photoGeoLocList = photoGeoLocList;
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

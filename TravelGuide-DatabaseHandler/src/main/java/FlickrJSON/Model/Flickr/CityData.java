package FlickrJSON.Model.Flickr;

import java.io.Serializable;
import java.util.List;

public class CityData implements Serializable {
    private String cityName;
    private String cityId;
    private List<Region> regionList;

    public CityData(String cityName, String cityId, List<Region> regionList) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.regionList = regionList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }


    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

}

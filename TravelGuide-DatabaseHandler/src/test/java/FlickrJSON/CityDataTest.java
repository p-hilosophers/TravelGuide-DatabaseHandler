package FlickrJSON;

import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class CityDataTest {

    CityInfo cityInfo = new CityInfo();
    CityData cd;
    @org.junit.Test
    public void testData() throws JSONException {
        cityInfo.placeIdFromJSON("London");
        CityData cd = cityInfo.getCityData();
        cd.getRegionList();

        List<Region> regionList = new LinkedList<>();
        List<Region> rr1 = new LinkedList<>();

        regionList = cd.getRegionList();
        for(Region r : regionList){
            r.getPhotoGeoLocList().clear();
        }
        rr1.add(new Region("Shoreditch","m3hb5ZZSVr3OFg","137099",null));

        assertEquals(rr1.get(0).getName(),regionList.get(0).getName());
        assertEquals(rr1.get(0).getRegionId(),regionList.get(0).getRegionId());
        assertEquals(rr1.get(0).getCountPhoto(),regionList.get(0).getCountPhoto());


    }

    @org.junit.Test
    public void cityNameTest() throws JSONException {
        cityInfo.placeIdFromJSON("London");
        CityData cd = cityInfo.getCityData();
        assertEquals("London",cd.getCityName());
        assertEquals("hP_s5s9VVr5Qcg",cd.getCityId());

    }

}
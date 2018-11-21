package FlickrJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FlickrRequestTest {

    @org.junit.Test
    public void getPlaceId() throws JSONException {
        FlickrRequest flickrRequest = new FlickrRequest();
        flickrRequest.getPlaceId("London");
        Map o1 =  new LinkedHashMap() ;
        JSONObject jsonObject = (JSONObject) o1;

        JSONArray list = new JSONArray();

        o1.put("place_id","hP_s5s9VVr5Qcg");
        o1.put("woeid","44418");
        o1.put("latitude","51.506");
        o1.put("longitude","-0.127");
        o1.put("place_url","\\/United+Kingdom\\/England\\/London");
        o1.put("place_type","locality");
        o1.put("place_type_id","7");
        o1.put("timezone","Europe\\/London");
        o1.put("_content","London, England, United Kingdom");
        o1.put("woe_name","London");


        assertEquals(o1,flickrRequest.getResponseJSON_Format().getJSONObject("places").getJSONArray("places").getJSONObject(0));
    }
}
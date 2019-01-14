package FlickrJSON.Model.Retrievers;

import FlickrJSON.Services.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class SightsList {

    private List<String> sightIdList = new LinkedList<>();
    private List<String> sightNameList = new LinkedList<>();

    public void getSightList(String cityName){

        try{
            HttpRequest httpRequest = new HttpRequest();
            JSONArray jsonArray = httpRequest.request("http://35.204.237.100:8081/cities/" + cityName +"/sights");

            for(int i =0;i<jsonArray.length();i++){
                JSONObject json = (JSONObject) jsonArray.get(i);
                sightIdList.add(json.getString("sightId"));
                sightNameList.add(json.getString("name"));
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public List<String> getSightIdList() {
        return sightIdList;
    }

    public List<String> getSightNameList() {
        return sightNameList;
    }
}

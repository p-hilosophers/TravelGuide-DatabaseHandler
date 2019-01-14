package FlickrJSON.Model.Retrievers;

import FlickrJSON.Services.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CityList {

    private List<String> cityList = new LinkedList<>();
    private List<String> cityId = new LinkedList<>();

    public void retrieveCityList(){

        try{
            HttpRequest httpRequest = new HttpRequest();
            JSONArray jsonArray = httpRequest.request("http://35.204.237.100:8081/cities");

            for(int i =0;i<jsonArray.length();i++){
                JSONObject json = (JSONObject) jsonArray.get(i);
                cityList.add(json.getString("name"));
                cityId.add(json.getString("cityId"));
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }


    }

    public List<String> getCityId() {
        return cityId;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }
}

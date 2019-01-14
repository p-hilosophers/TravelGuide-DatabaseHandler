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

public class PhotoList {

    private List<String> photoIdList = new LinkedList<>();

    public void retrievePhotoList(String sightName){

        try{

            sightName = sightName.replaceAll(" ","%20");
            HttpRequest httpRequest = new HttpRequest();
            JSONArray jsonArray = httpRequest.request("http://35.204.237.100:8081/sights/" + sightName + "/photos");

            for(int i =0;i<jsonArray.length();i++){
                JSONObject json = (JSONObject) jsonArray.get(i);
                photoIdList.add(json.getString("name"));

            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    public List<String> getPhotoIdList() {
        return photoIdList;
    }
}

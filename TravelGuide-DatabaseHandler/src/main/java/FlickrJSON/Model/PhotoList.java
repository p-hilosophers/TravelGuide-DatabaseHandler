package FlickrJSON.Model;

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
            URL urlObj = new URL("http://83.212.103.26:8081/sights/" + sightName + "/photos");
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            BufferedReader in = new BufferedReader( new InputStreamReader((con.getInputStream())));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            JSONArray jsonArray = new JSONArray(response.toString());
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

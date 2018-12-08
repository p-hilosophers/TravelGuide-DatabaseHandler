package FlickrJSON.Model.Retrievers;

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
            URL urlObj = new URL("http://83.212.103.26:8081/cities/" + cityName +"/sights");
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

package FlickrJSON.Model;

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
            URL urlObj = new URL("http://83.212.103.26:8081/cities");
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

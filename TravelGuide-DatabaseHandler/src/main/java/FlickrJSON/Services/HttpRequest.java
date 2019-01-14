package FlickrJSON.Services;

import com.google.gson.JsonArray;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {


    public JSONArray request(String url){
        StringBuilder response = new StringBuilder();
        JSONArray jsonArray = new JSONArray();
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            jsonArray = new JSONArray(response.toString());
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return jsonArray;
    }
}

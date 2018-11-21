package FlickrJSON;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlickrRequest {


    private JSONObject responseJSON_Format;
    private final String apiKey = "90a1ec87216b294a03bf2ca693ab9255";
    private String url = "";

    public void getPhotosByGeoLoc(String latitude , String longitude,String radius){
            url ="https://api.flickr.com/services/rest/?method=flickr.photos.search"+
                        "&api_key=" + apiKey +
                        "&lat=" + latitude +
                        "&lon=" + longitude +
                        "&radius=" + radius +
                        "&radius_units=km&format=json&nojsoncallback=1";
            httpRequest();
    }

    public void getPlaceId(String landscape){
            url = "https://api.flickr.com/services/rest/?method=flickr.places.find"+
                    "&api_key="+ apiKey+
                    "&query="+landscape+
                    "&format=json&nojsoncallback=1";
            httpRequest();
    }

    public void photoCountPerRegion(String placeId){
            url = "https://api.flickr.com/services/rest/?method=flickr.places.getChildrenWithPhotosPublic"+
                    "&api_key="+apiKey+
                    "&place_id="+placeId+
                    "&format=json&nojsoncallback=1";
            httpRequest();
    }

    public void geoLocFromPhoto(String photoId){
        url = "https://api.flickr.com/services/rest/?method=flickr.photos.geo.getLocation" +
                "&photo_id=" + photoId +
                "&place_id=EsIQUYZXU79_kEA"+
                "&api_key="+apiKey+
                "&format=json&nojsoncallback=1";
        httpRequest();
    }

    public void getImgUrl(String photoId){
        url = "https://api.flickr.com/services/rest/?method=flickr.photos.getSizes" +
                "&photo_id=" + photoId +
                "&api_key="+apiKey+
                "&format=json&nojsoncallback=1";
        httpRequest();
    }


    private void httpRequest(){
        if(url != null){
            try{
                URL urlObj = new URL(this.url);
                HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
                int responseCode = con.getResponseCode();
                //System.out.println("Response Code : " + String.valueOf(responseCode));

                BufferedReader in = new BufferedReader( new InputStreamReader((con.getInputStream())));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();

                responseJSON_Format = new JSONObject(response.toString());
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }

    }


    public JSONObject getResponseJSON_Format() {
        return responseJSON_Format;
    }

    public void setResponseJSON_Format(JSONObject responseJSON_Format) {
        this.responseJSON_Format = responseJSON_Format;
    }

    public String getApiKey() {
        return apiKey;
    }


}

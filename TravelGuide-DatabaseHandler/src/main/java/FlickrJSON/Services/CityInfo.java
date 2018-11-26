package FlickrJSON.Services;

import FlickrJSON.Model.Flickr.CityData;
import FlickrJSON.Model.Flickr.PhotoGeoLoc;
import FlickrJSON.Model.Flickr.Region;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CityInfo {

    private FlickrRequest flickrRequest = new FlickrRequest();
    private CityData cityData;


    public void placeIdFromJSON(String nameOfPlace) {
        try {
            flickrRequest.getPlaceId(nameOfPlace);
            JSONObject placeId_json = flickrRequest.getResponseJSON_Format();
            String placeId = placeId_json.getJSONObject("places").getJSONArray("place").getJSONObject(0).getString("place_id");

            cityData = new CityData(nameOfPlace, placeId, getTopPhotoCountOfRegion(placeId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<Region> getTopPhotoCountOfRegion(String placeId) {
        List<Region> regions = new ArrayList<>();
        flickrRequest.photoCountPerRegion(placeId);
        JSONObject region_json = flickrRequest.getResponseJSON_Format();
        try {
            for (int i = 0; i < 15; i++) {

                String regionName = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("woe_name");
                String regionId = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("place_id");
                String latitude = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("latitude");
                String longitude = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("longitude");
                String photoCount = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("photo_count");


                regions.add(new Region(regionName, regionId, photoCount, latitude, longitude, getPhotoListByGeoLoc(latitude, longitude)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return regions;

    }

    private List<PhotoGeoLoc> getPhotoListByGeoLoc(String latitude, String longitude) {
        flickrRequest.getPhotosByGeoLoc(latitude, longitude, "0.3");
        List<PhotoGeoLoc> photoGeoLocsList = new ArrayList<>();
        JSONObject photoId_json = flickrRequest.getResponseJSON_Format();
        try {
            for (int i = 0; i < 15 ; i++) {

                String photoId = photoId_json.getJSONObject("photos").getJSONArray("photo").getJSONObject(i).getString("id");
                photoGeoLocsList.add(getGeoLocFromPhotoId(photoId));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return photoGeoLocsList;
    }

    private PhotoGeoLoc getGeoLocFromPhotoId(String photoId) throws JSONException {
        flickrRequest.geoLocFromPhoto(photoId);
        JSONObject photoGeoLoc_json = flickrRequest.getResponseJSON_Format();
        return new PhotoGeoLoc(photoGeoLoc_json.getJSONObject("photo").getJSONObject("location").getString("latitude"),
                photoGeoLoc_json.getJSONObject("photo").getJSONObject("location").getString("longitude"), photoId, getImgUrl(photoId));
    }

    private String getImgUrl(String photoId) throws JSONException {
        flickrRequest.getImgUrl(photoId);
        JSONObject imgUrl_json = flickrRequest.getResponseJSON_Format();
        return imgUrl_json.getJSONObject("sizes").getJSONArray("size").getJSONObject(imgUrl_json.getJSONObject("sizes").getJSONArray("size").length() - 1).getString("source");

    }

    public CityData getCityData() {
        return cityData;
    }
}
package FlickrJSON;

import Model.City;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PhotoList {

    private List<String> photoIdList = new ArrayList<>();
    private FlickrRequest flickrRequest = new FlickrRequest();
    private JSONObject placeId_json = new JSONObject();
    private JSONObject region_json = new JSONObject();
    private JSONObject photoId_json = new JSONObject();
    private JSONObject photoGeoLoc_json = new JSONObject();
    private List<PhotoGeoLoc> photoGeoLocsList;
    private CityData cityData;


    public void placeIdFromJSON(String nameOfPlace) throws JSONException {
        flickrRequest.getPlaceId(nameOfPlace);
        placeId_json = flickrRequest.getResponseJSON_Format();
        String placeId = placeId_json.getJSONObject("places").getJSONArray("place").getJSONObject(0).getString("place_id");

        cityData = new CityData(placeId,nameOfPlace,getTopPhotoCountOfRegion(placeId));
    }

    private List<Region> getTopPhotoCountOfRegion(String placeId) throws JSONException {
        List<Region> regions = new ArrayList<>();
        flickrRequest.photoCountPerRegion(placeId);
        region_json = flickrRequest.getResponseJSON_Format();
        for (int i = 0; i < 5; i++) {

            String regionName = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("woe_name");
            String regionId = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("place_id");
            String latitude = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("latitude");
            String longitude = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("longitude");
            String photoCount = region_json.getJSONObject("places").getJSONArray("place").getJSONObject(i).getString("photo_count");


            regions.add(new Region(regionName,regionId,getPhotoListByGeoLoc(latitude, longitude)));
        }

        return regions;

    }

    private List<PhotoGeoLoc> getPhotoListByGeoLoc(String latitude, String longitude) throws JSONException {
        flickrRequest.getPhotosByGeoLoc(latitude, longitude, "2");
        photoGeoLocsList = new ArrayList<>();
        photoId_json = flickrRequest.getResponseJSON_Format();
        for (int i = 0; i < 25; i++) {

            String photId = photoId_json.getJSONObject("photos").getJSONArray("photo").getJSONObject(i).getString("id");
            photoGeoLocsList.add(getGeoLocFromPhotoId(photId));
        }
        return photoGeoLocsList;
    }

    private PhotoGeoLoc getGeoLocFromPhotoId(String photoId) throws JSONException {
        flickrRequest.geoLocFromPhoto(photoId);
        photoGeoLoc_json = flickrRequest.getResponseJSON_Format();
        return new PhotoGeoLoc(photoGeoLoc_json.getJSONObject("photo").getJSONObject("location").getString("latitude"),
                photoGeoLoc_json.getJSONObject("photo").getJSONObject("location").getString("longitude"), photoId);
    }

    public List<String> getPhotoIdList() {
        return photoIdList;
    }

}

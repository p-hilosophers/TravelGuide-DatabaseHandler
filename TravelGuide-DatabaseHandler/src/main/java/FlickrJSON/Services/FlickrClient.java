package FlickrJSON.Services;


import FlickrJSON.Model.Flickr.CityData;
import FlickrJSON.Model.BackEnd.Photo;
import FlickrJSON.Model.BackEnd.Sight;
import retrofit2.Call;
import retrofit2.http.*;

public interface FlickrClient {

    @POST("cityData")
    Call<CityData> sendCityData(@Body CityData cityData);

    @POST("/cities/{cityId}/sights")
    Call<Sight> sendSight(@Path("cityId") String cityId
            , @Body Sight sight);

    @POST("/sights/{sightId}/photos")
    Call<Photo> sendPhoto(@Path("sightId") String sightId
            , @Body Photo photo);



}


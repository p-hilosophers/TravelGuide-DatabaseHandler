package FlickrJSON;

import Model.City;
import Model.Photo;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.*;

public interface FlickrClient {

    @GET("/services/rest/")
    Call<JsonObject> getPlaceId(@Query("method") String method
            , @Query("api_key") String apiKey
            , @Query("format") String format
            , @Query("nojsoncallback") String nojsoncallback
            , @Query("query") String query);

    @GET("/services/rest/")
    Call<JsonObject> getRequest(@Query("method") String method
            , @Query("api_key") String apiKey
            , @Query("format") String format
            , @Query("nojsoncallback") String nojsoncallback
            , @Query("query") String query);
    @POST("cities")
    Call<City> createUser(@Body City city);

    @POST("cities/{cityId}/photos/")
    Call<Photo> uploadPhoto(@Path("cityId") String cityId, @Body Photo photo);

}


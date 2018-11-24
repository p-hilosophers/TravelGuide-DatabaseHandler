package FlickrJSON;


import retrofit2.Call;
import retrofit2.http.*;

public interface FlickrClient {

    @POST("cityData")
    Call<CityData> sendCityData(@Body CityData cityData);



}


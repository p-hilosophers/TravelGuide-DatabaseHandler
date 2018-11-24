package FlickrJSON;


import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainTest {


    public static void main(String[] args) {

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.10.8:8080/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        FlickrClient client = retrofit.create(FlickrClient.class);

        CityInfo cityInfo;
        for(int i =0; i<args.length;i++){
            cityInfo = new CityInfo();
            cityInfo.placeIdFromJSON(args[i]);

            Call<CityData> call = client.sendCityData(cityInfo.getCityData());
            call.enqueue(new Callback<CityData>() {
                @Override
                public void onResponse(Call<CityData> call, Response<CityData> response) {

                }

                @Override
                public void onFailure(Call<CityData> call, Throwable t) {
                }
            });
        }

    }


}

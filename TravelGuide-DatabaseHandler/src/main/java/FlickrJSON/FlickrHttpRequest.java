package FlickrJSON;

import com.google.gson.JsonObject;
import retrofit2.*;

public class FlickrHttpRequest {

    private JsonParser jsonParser;
    private final String apiKey = "90a1ec87216b294a03bf2ca693ab9255";
    private final String responseType = "json&nojsoncallback=1";
    private final String url = "https://api.flickr.com/";
    private String method = "";
    private FlickrClient flickrClient;


    public void setMethod(String method){
        this.method = method;
                //"flickr.places.find";

        //System.out.println(jsonParser.getJsonObject());
    }

    public FlickrHttpRequest() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        flickrClient = retrofit.create(FlickrClient.class);
    }

    public void placeIdRequest(String place) {
        Call<JsonObject> caller = flickrClient.getRequest(method, apiKey, "json", "1", place);
        execute(caller);
    }

    private void execute(Call<JsonObject> caller){
        caller.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                jsonParser = new JsonParser(response.body());
                System.out.println(jsonParser.getJsonObject().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                System.out.println("error");
            }
        });

    }


}

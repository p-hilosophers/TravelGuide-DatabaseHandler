package FlickrJSON;

import Model.City;
import Model.Photo;
import retrofit2.*;

import java.io.IOException;

public class MainTest {


    public static void main(String[] args) throws IOException {
























        /*FlickrRequest flickrRequest = new FlickrRequest();
        PhotoList photoList = new PhotoList();

        photoList.placeIdFromJSON("London");

        */
        //PostHttpRequest postHttpRequest =new PostHttpRequest();
        //postHttpRequest.test();

        /*Retrofit.Builder retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit1 = retrofit.build();
        FlickrClient flickrClient = retrofit1.create(FlickrClient.class);
        City city = new City();
        city.setLatitude(33);
        city.setLongitude(44);
        city.setName("12345");
        Photo photo = new Photo();
        photo.setLatitude(11);
        photo.setLongitude(22);
        photo.setName("test");

        Call<Photo> call = flickrClient.uploadPhoto("d31df895-fc9c-41e5-bd11-5047c1bb5517",photo);
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                System.out.println(response.body().getName());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable throwable) {
                System.out.println("error");
            }
        });*/






    }


}

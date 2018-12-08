package FlickrJSON;


import FlickrJSON.Model.Flickr.Season;
import FlickrJSON.Services.CityInfo;
import FlickrJSON.Services.SeasonOfReg;
import org.json.JSONException;


public class Main {


    public static void main(String[] args) {
        /*CityList retrieveCityList = new CityList();
        retrieveCityList.retrieveCityList();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://83.212.103.26:8081/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        FlickrClient client = retrofit.create(FlickrClient.class);
        List<String> cityList = retrieveCityList.getCityList();
        List<String> cityId = retrieveCityList.getCityId();


        for (int i = 0; i < cityList.size(); i++) {
            CityData cd;
            CityInfo cityInfo;
            cityInfo = new CityInfo();
            cityInfo.placeIdFromJSON(cityList.get(i));
            SightsList sightsList = new SightsList();
            sightsList.getSightList(cityList.get(i));

            cd = cityInfo.getCityData();

            for (Region region : cd.getRegionList()) {

                int index = sightsList.getSightNameList().indexOf(region.getName());
                String sightId = "";
                if(index != -1) {
                    sightId = sightsList.getSightIdList().get(index);
                }
                if (sightsList.getSightNameList().contains(region.getName())) {
                    PhotoList photoList = new PhotoList();
                    photoList.retrievePhotoList(region.getName());
                    List<String> photoIdList = photoList.getPhotoIdList();

                    for(PhotoGeoLoc photoGeoLoc : region.getPhotoGeoLocList()){
                        if(!photoIdList.contains(photoGeoLoc.getId())) {

                            Photo photo = new Photo(photoGeoLoc.getId(),
                                    Double.parseDouble(photoGeoLoc.getLongitude()),
                                    Double.parseDouble(photoGeoLoc.getLatitude()),
                                    photoGeoLoc.getImgUrl());
                            Call<Photo> caller = client.sendPhoto(sightId,photo);
                            String finalSightId = sightId;
                            caller.enqueue(new Callback<Photo>() {
                                @Override
                                public void onResponse(Call<Photo> call, Response<Photo> response) {
                                    System.out.println("Uploaded photo" + finalSightId + " " + response.body().getName());
                                }

                                @Override
                                public void onFailure(Call<Photo> call, Throwable throwable) {
                                    System.out.println(throwable.toString());
                                }
                            });
                        }
                    }
                } else {
                    Sight sight = new Sight(region.getName(), Double.parseDouble(region.getLongitude()), Double.parseDouble(region.getLatitude()),region.getCountPhoto());
                    Call<Sight> caller = client.sendSight(cityId.get(i),sight);
                    caller.enqueue(new Callback<Sight>() {
                        @Override
                        public void onResponse(Call<Sight> call, Response<Sight> response) {
                            System.out.println("success");
                        }

                        @Override
                        public void onFailure(Call<Sight> call, Throwable throwable) {

                        }
                    });
                }
            }

        }*/

        CityInfo cityInfo = new CityInfo();
        cityInfo.placeIdFromJSON("Paris");
        cityInfo.placeIdFromJSON("Athens");

        System.out.println();



    }


}

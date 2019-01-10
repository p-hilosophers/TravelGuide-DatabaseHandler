package FlickrJSON.Services;

import FlickrJSON.Model.Flickr.PhotoGeoLoc;

import java.util.List;

public class RegionHour {

    private String hourToVisit;


    public String hourDecide(List<PhotoGeoLoc> photoGeoLocs){
        int daySum = 0,nightSum = 0;

        for (PhotoGeoLoc photoGeoLoc : photoGeoLocs ){
            switch (photoGeoLoc.getDayNight()) {
                case "Day":
                    daySum++;
                    break;

                case "Night":
                    nightSum++;
                    break;
            }
        }

        double limit = photoGeoLocs.size() * 0.6;
        if(daySum >= limit ) return "Day";
        else if (nightSum >= limit) return "Night";
        else return "Both";
    }


}

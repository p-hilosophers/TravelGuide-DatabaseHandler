package FlickrJSON.Services;

import FlickrJSON.Model.Flickr.PhotoGeoLoc;
import FlickrJSON.Model.Flickr.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeasonOfRegion {


    public String decideSeason(List<PhotoGeoLoc> photoGeoLocList) {
        Season spring = Season.Spring;
        Season summer = Season.Summer;
        Season fall = Season.Fall;
        Season winter = Season.Winter;


        for (PhotoGeoLoc photo : photoGeoLocList) {
            String season = photo.getSeason();
            switch (season) {
                case "Spring":
                    spring.setSum();
                    break;
                case "Summer":
                    summer.setSum();
                    break;
                case "Fall":
                    fall.setSum();
                    break;
                case "Winter":
                    winter.setSum();
                    break;

            }
        }

        int sizeOfList = photoGeoLocList.size();
        List<Season> seasonList = Arrays.asList(spring, summer, fall, winter);

        String finalSeason = "";
        for (Season season : seasonList) {
            int sum = season.getSum();
            if (sum >= sizeOfList * 0.6) {
                finalSeason = season.getName();
            }
            season.clear();
        }
        if (finalSeason.equals("")) {
            finalSeason = "MultiSeason";
        }

        return finalSeason;

    }


}

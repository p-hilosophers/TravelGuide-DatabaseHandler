package FlickrJSON.Model.Flickr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SeasonDateTimeDto {

    private String dateTime;
    private String season;
    private String dayNight;


    private String setSeason(int monthDay) {
        String season;

        if (monthDay <= 315) {
            season = "Winter";
        } else if (monthDay <= 615) {
            season = "Spring";
        } else if (monthDay <= 915) {
            season = "Summer";
        } else if (monthDay <= 1215) {
            season = "Fall";
        } else {
            season = "Winter";
        }
        return season;
    }

    private String dayNightDecide(String photoHour) {
        int hour = Integer.parseInt(photoHour);
        String dayNight;
        if (hour >=6 && hour <=19){
            dayNight = "Day";
        }
        else dayNight = "Night";

        return dayNight;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, sdf);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.dateTime = dateTime;
        String test = new SimpleDateFormat("H").format(date);
        this.dayNight = dayNightDecide(new SimpleDateFormat("H").format(date));
        this.season = setSeason(localDateTime.getMonthValue() * 100 + localDateTime.getDayOfMonth());
    }

    public String getDayNight() {
        return dayNight;
    }

    public String getSeason() {
        return season;
    }

}

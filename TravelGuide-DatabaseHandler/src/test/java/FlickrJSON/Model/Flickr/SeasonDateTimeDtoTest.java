package FlickrJSON.Model.Flickr;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonDateTimeDtoTest {

    SeasonDateTimeDto seasonDateTimeDto = new SeasonDateTimeDto();

    @Test
    public void dayNightTest(){

        assertEquals("Night",seasonDateTimeDto.dayNightDecide("0"));
        assertEquals("Day",seasonDateTimeDto.dayNightDecide("7"));

    }

    @Test
    public void seasonTest(){
        assertEquals("Summer",seasonDateTimeDto.setSeason(905));
        assertEquals("Winter",seasonDateTimeDto.setSeason(13));
        assertEquals("Fall",seasonDateTimeDto.setSeason(1000));
        assertEquals("Spring",seasonDateTimeDto.setSeason(400));
        assertEquals("Winter",seasonDateTimeDto.setSeason(1399));
    }

}
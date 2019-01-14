package FlickrJSON.Model.Retrievers;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CityListTest {

    private static String jsonArray = "";
    private static List<String> cityNames;
    @BeforeClass
    public static void setUpClass(){
        cityNames = new ArrayList<>();
        String filePath = "/home/arxontispipertzis/Documents/GitHub/Java/TravelGuide-DatabaseHandler/TravelGuide-DatabaseHandler/src/test/java/FlickrJSON/cities.txt";
        StringBuilder contentBuilder = new StringBuilder();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String sCurrentLine = "";
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        cityNames.addAll(Arrays.asList(contentBuilder.toString().replace("\n","").split(",")));

    }


    @Test
    public void retrieveCityListTest() {
        CityList cityList = mock(CityList.class);
        List<String> list = new LinkedList<>(Arrays.asList("London", "Paris", "Athens", "Barcelona"));
        cityList.setCityList(list);
        when(cityList.getCityList()).thenReturn(list);
        assertEquals(cityNames,cityList.getCityList());
        verify(cityList);

    }
}
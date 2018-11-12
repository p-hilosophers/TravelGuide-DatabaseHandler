package Controller;

import Exception.ResourceNotFoundException;
import Model.City;
import Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities()
    {
        return cityRepository.findAll();
    }

    @PostMapping("/cities")
    public City addCity(@Valid @RequestBody City city)
    {
        return  cityRepository.save(city);
    }

    @PutMapping("/cities/{cityId}")
    public  City updateCity(@PathVariable UUID cityId,
                            @Valid @RequestBody City cityRequest)
    {
        return cityRepository.findById(cityId)
                .map(city -> {
                    city.setLatitude(cityRequest.getLatitude());
                    city.setLongitude(cityRequest.getLongitude());
                    city.setName(cityRequest.getName());
                    city.setPhotoCount(cityRequest.getPhotoCount());
                    city.setPhoto(cityRequest.getPhoto());
                    return cityRepository.save(city);
                }).orElseThrow(()-> new ResourceNotFoundException("City not found with id" +cityId));
    }
    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable UUID cityId)
    {
        return cityRepository.findById(cityId)
                .map(city -> {
                    cityRepository.delete(city);
                    return  ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException("City not found with id" +cityId));
    }

    @GetMapping("cities/{cityName}")
    public City getCityByName(@PathVariable String cityName)
    {
        return cityRepository.findByName(cityName);
    }
}

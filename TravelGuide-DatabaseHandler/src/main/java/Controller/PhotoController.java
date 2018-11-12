package Controller;

import Exception.ResourceNotFoundException;
import Model.Photo;
import Repository.CityRepository;
import Repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities/{cityId}/photos")
    public Page<Photo> getPhotosByCityId(@PathVariable(value = "cityId") UUID cityId,
                                         Pageable pageable)
    {
        return photoRepository.findByCity_CityId(cityId,pageable);
    }

    @PostMapping("/cities/{cityId}/photos")
    public Photo addPhoto(@PathVariable UUID cityId,
                          @Valid @RequestBody Photo photo)
    {
        return cityRepository.findById(cityId)
                .map(city -> {
                    photo.setCity(city);
                    return photoRepository.save(photo);
                }).orElseThrow(()-> new ResourceNotFoundException("City not found with id"+cityId));
    }
    @PutMapping("/cities/{cityId}/photos/{photoId}")
    public Photo updatePhoto(@PathVariable UUID cityId,
                             @PathVariable UUID photoId,
                             @Valid @RequestBody Photo photoRequest)
    {
        if (!cityRepository.existsById(cityId))
        {
            throw new ResourceNotFoundException("City not found with id "+cityId);

        }
        return  photoRepository.findById(photoId)
                .map(photo -> {
                    photo.setName(photoRequest.getName());
                    photo.setImage(photoRequest.getImage());
                    photo.setLatitude(photoRequest.getLatitude());
                    photo.setLongitude(photoRequest.getLongitude());
                    photo.setThumbnail(photoRequest.getThumbnail());
                    photo.setCity(photoRequest.getCity());
                    return  photoRepository.save(photo);
                }).orElseThrow(()->new ResourceNotFoundException("Photo not found with id"+photoId));
    }
    @DeleteMapping("/cities/{cityId}/photos/{photoId}")
    public ResponseEntity<?> deletePhoto(@PathVariable UUID cityId,
                                         @PathVariable UUID photoId)
    {
        if (!cityRepository.existsById(cityId))
        {
            throw new ResourceNotFoundException("City not found with id "+cityId);

        }
        return photoRepository.findById(photoId)
                .map(photo -> {
                    photoRepository.delete(photo);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()->new ResourceNotFoundException("Photo not found with id"+photoId));
    }

}

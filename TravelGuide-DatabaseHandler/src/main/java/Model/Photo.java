package Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table (name="photos")
public class Photo {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idPhoto;

    private String name;

    private double longitude;

    private double latitude;


    //TODO: make this to String (URL)
    private byte[] image;

    private byte[] thumbnail;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="cityId",referencedColumnName = "cityId")
    private City city;

    public Photo(){}
    public UUID getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(UUID idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

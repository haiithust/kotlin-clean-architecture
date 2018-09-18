package technology.olala.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author conghai on 8/12/18.
 */
@Entity(nameInDb = "city_list")
public class CityInfoEntity {
    @Id
    private Long cityId;
    @Property(nameInDb = "name")
    private String cityName;
    @Property(nameInDb = "country")
    private String country;
    @Property(nameInDb = "latitude")
    private double latitude;
    @Property(nameInDb = "longitude")
    private double longitude;
    @Generated(hash = 792014608)
    public CityInfoEntity(Long cityId, String cityName, String country,
            double latitude, double longitude) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Generated(hash = 809957419)
    public CityInfoEntity() {
    }
    public Long getCityId() {
        return this.cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

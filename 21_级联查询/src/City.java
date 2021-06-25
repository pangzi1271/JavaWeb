public class City {

    private String cityName;
    private Integer provinceId;

    public City(String cityName, Integer provinceId) {
        this.cityName = cityName;
        this.provinceId = provinceId;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
}

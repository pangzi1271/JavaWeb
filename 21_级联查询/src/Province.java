public class Province {
    private Integer provinceId;
    private String provinceName;
    private String provinceShortName;
    private String capital;

    public Province() {
    }

    public Province(Integer provinceId, String provinceName, String provinceShortName, String capital) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.capital = capital;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}

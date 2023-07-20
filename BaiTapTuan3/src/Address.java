public class Address {
    private String province;
    private String district;
    private String commune;
    private String homeNumber;

    public Address() {}
    public Address(String province, String district, String commune, String homeNumber) {
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.homeNumber = homeNumber;
    }

    public String getProvince() {
        return province;
    }

    public String getDistrict() {
        return district;
    }

    public String getCommune() {
        return commune;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    @Override
    public String toString() {
        return ". Province: " + province + ", district: " + district + ", commune: " + commune
        + ", homeNumber: " + homeNumber;
    }
}

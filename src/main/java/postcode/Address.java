package postcode;

public class Address {
    private String street;
    private String place;
    private String addition;
    private int houseNumber;
    private String postcode;

    Address() {
    }

    public String getStreet() {
        return street;
    }

    void setStreet(String street) {
        this.street = street;
    }

    public String getPlace() {
        return place;
    }

    void setPlace(String place) {
        this.place = place;
    }

    public String getAddition() {
        return addition;
    }

    void setAddition(String addition) {
        this.addition = addition;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}


package ebogrs;

public class Address {
        String door_no,street,city,district,state,pincode;

    public Address(String door_no, String street, String city, String district, String state, String pincode) {
        this.door_no = door_no;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
    }

    public String getDoor_no() {
        return door_no;
    }

    public void setDoor_no(String door_no) {
        this.door_no = door_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}



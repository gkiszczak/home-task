package pl.inpost.home.task.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Point {
    private String name; 
    private Location location;
    
    public Location getLocation(){
        return this.location;
    }
    
    public void setLocation(Location location){
        this.location = location;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    @JsonProperty("address_details")
    private AddressDetails addressDetails;

}

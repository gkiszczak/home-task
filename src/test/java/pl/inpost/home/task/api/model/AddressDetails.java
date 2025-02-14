package pl.inpost.home.task.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDetails {

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @JsonProperty("post_code")
    private String postCode;
}

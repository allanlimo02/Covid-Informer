
package com.moringaschool.covidinformer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Parameters {

    @SerializedName("country")
    @Expose
    private String country;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parameters() {
    }

    /**
     * 
     * @param country
     */
    public Parameters(String country) {
        super();
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

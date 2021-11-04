
package com.moringaschool.covidinformer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Response {

    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private Object population;
    @SerializedName("cases")
    @Expose
    private Cases cases;
    @SerializedName("deaths")
    @Expose
    private Deaths deaths;
    @SerializedName("tests")
    @Expose
    private Tests tests;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("time")
    @Expose
    private String time;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param continent
     * @param country
     * @param cases
     * @param tests
     * @param time
     * @param day
     * @param deaths
     * @param population
     */
    public Response(String continent, String country, Object population, Cases cases, Deaths deaths, Tests tests, String day, String time) {
        super();
        this.continent = continent;
        this.country = country;
        this.population = population;
        this.cases = cases;
        this.deaths = deaths;
        this.tests = tests;
        this.day = day;
        this.time = time;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getPopulation() {
        return population;
    }

    public void setPopulation(Object population) {
        this.population = population;
    }

    public Cases getCases() {
        return cases;
    }

    public void setCases(Cases cases) {
        this.cases = cases;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public Tests getTests() {
        return tests;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

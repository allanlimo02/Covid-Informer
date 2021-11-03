
package com.moringaschool.covidinformer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Cases {

    @SerializedName("new")
    @Expose
    private String _new;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("critical")
    @Expose
    private Integer critical;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("1M_pop")
    @Expose
    private String _1MPop;
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cases() {
    }

    /**
     * 
     * @param recovered
     * @param total
     * @param critical
     * @param _1MPop
     * @param active
     * @param _new
     */
    public Cases(String _new, Integer active, Integer critical, Integer recovered, String _1MPop, Integer total) {
        super();
        this._new = _new;
        this.active = active;
        this.critical = critical;
        this.recovered = recovered;
        this._1MPop = _1MPop;
        this.total = total;
    }

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public String get1MPop() {
        return _1MPop;
    }

    public void set1MPop(String _1MPop) {
        this._1MPop = _1MPop;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}

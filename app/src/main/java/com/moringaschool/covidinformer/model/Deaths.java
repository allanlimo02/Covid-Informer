
package com.moringaschool.covidinformer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Deaths {

    @SerializedName("new")
    @Expose
    private String _new;
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
    public Deaths() {
    }

    /**
     * 
     * @param total
     * @param _1MPop
     * @param _new
     */
    public Deaths(String _new, String _1MPop, Integer total) {
        super();
        this._new = _new;
        this._1MPop = _1MPop;
        this.total = total;
    }

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
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

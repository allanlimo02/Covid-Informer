
package com.moringaschool.covidinformer.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Tests {

    @SerializedName("1M_pop")
    @Expose
    private Object _1MPop;
    @SerializedName("total")
    @Expose
    private Object total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tests() {
    }

    /**
     * 
     * @param total
     * @param _1MPop
     */
    public Tests(Object _1MPop, Object total) {
        super();
        this._1MPop = _1MPop;
        this.total = total;
    }

    public Object get1MPop() {
        return _1MPop;
    }

    public void set1MPop(Object _1MPop) {
        this._1MPop = _1MPop;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

}

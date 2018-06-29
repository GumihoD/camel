package com.yvan.camel.route;

public class Invoice {

    private Integer id;

    private String grossValue;

    public String getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(String grossValue) {
        this.grossValue = grossValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.example.android51.rv_et;

import java.io.Serializable;

public class Model implements Serializable {

    private String name;
    private String phone;

    public Model(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

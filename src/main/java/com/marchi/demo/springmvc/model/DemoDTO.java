package com.marchi.demo.springmvc.model;

import java.io.Serializable;

public class DemoDTO implements Serializable{

    private Long id;
    private String name;

    public DemoDTO() {
        super();
    }

    public DemoDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

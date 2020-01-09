package com.application.architecture.models;

import org.springframework.stereotype.Component;

@Component
public class MyUser {
    String name;

    public MyUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}

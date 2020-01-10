package com.application.architecture.models;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class MyUser {
    @Id
    private long userId;
    String name;

    public MyUser() {
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}

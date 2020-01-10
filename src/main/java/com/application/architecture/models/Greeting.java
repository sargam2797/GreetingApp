package com.application.architecture.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long greetingId;
    private String message;

    public Greeting() {
    }

    public Greeting(long greetingId, String message) {
        this.greetingId = greetingId;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "greetingId=" + greetingId +
                ",message=" + message;
    }
}

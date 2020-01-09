package com.application.architecture.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue
    private long counter;
    private String message;

    public Greeting() {
    }

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "counter=" + counter +
                ",message=" + message;
    }
}

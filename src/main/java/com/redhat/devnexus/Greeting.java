package com.redhat.devnexus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Greeting extends PanacheEntity {

    String value;

    public Greeting() {
    }

    public Greeting(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "value='" + value + '\'' +
                ", id=" + id +
                '}';
    }

    public String getValue() {
        return value;
    }
}

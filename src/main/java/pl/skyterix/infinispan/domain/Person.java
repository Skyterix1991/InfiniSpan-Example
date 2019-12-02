package pl.skyterix.infinispan.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

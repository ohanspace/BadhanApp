package org.badhan.badhanapp.organograms.domain.model;

public class Organogram {
    private String uid;
    private String name;

    public Organogram(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}

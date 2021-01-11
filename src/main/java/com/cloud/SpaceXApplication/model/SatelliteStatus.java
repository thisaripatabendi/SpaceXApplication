package com.cloud.SpaceXApplication.model;

public enum SatelliteStatus {
	
    ATTACHED("attached"),
    DETACHED("detached");

    private String value;

    SatelliteStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

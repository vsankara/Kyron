package com.technobrain.trips.reports;

public class Configuration {
    String serverURI;
    String userName;
    public Configuration() {
    }

    public void setServerURI(String serverURI) {
        this.serverURI = serverURI;
    }

    public String getServerURI() {
        return serverURI;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

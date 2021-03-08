package ru.job4j.serialization.xml;


import com.sun.xml.txw2.annotation.XmlElement;

import java.io.Serializable;

@XmlElement(value = "passenger")
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;

    @javax.xml.bind.annotation.XmlElement
    private String name;
    @javax.xml.bind.annotation.XmlElement
    private Boolean driverLicense;

    public Passenger() {
    }

    public Passenger(String name, Boolean driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Boolean getDriverLicense() {
//        return driverLicense;
//    }
//
//    public void setDriverLicense(Boolean driverLicense) {
//        this.driverLicense = driverLicense;
//    }

    @Override
    public String toString() {
        return "Passenger{"
                + "name='" + name + '\''
                + ", driverLicense=" + driverLicense
                + '}';
    }
}

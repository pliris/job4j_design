package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@com.sun.xml.txw2.annotation.XmlElement(value = "engine")
public class Engine implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement
    private Boolean hybrid;
    @XmlElement
    private int power;

    public Engine() {
    }


    public Engine(Boolean isHybrid, int power) {
        this.hybrid = isHybrid;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "hybrid=" + hybrid +
                ", power=" + power +
                '}';
    }
}

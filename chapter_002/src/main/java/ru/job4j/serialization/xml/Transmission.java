package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlElement (value = "transmission")
public class Transmission implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private Boolean auto;

    public Transmission() {
    }

    public Transmission(Boolean auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "auto=" + auto +
                '}';
    }
}

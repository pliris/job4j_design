package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.io.StringWriter;

@XmlRootElement(name = "auto")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorType(XmlAccessType.PROPERTY)

public class Auto implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement
    private String name;
    private Transmission transmission;
    private Price price;
    private Engine engine;

    @XmlElementWrapper (name = "passengers")
    @XmlElement (name = "passenger")
    private Passenger[] passengers;

    public Auto() {
    }

    public Auto(String name, Transmission transmission, Price price, Engine engine, Passenger[] passengers) {
        this.name = name;
        this.transmission = transmission;
        this.price = price;
        this.engine = engine;
        this.passengers = passengers;
    }

}

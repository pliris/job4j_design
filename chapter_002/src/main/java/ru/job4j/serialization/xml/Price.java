package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlElement
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private int dollars;

    public Price() {
    }

    public Price(int price) {
        this.dollars = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + dollars +
                '}';
    }
}

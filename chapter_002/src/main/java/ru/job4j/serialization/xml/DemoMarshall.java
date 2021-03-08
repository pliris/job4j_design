package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class DemoMarshall {


    public static void main(String[] args) throws JAXBException {
        Passenger[] passengers = new Passenger[2];
        passengers[0] = new Passenger("Tom", false);
        passengers[1] = new Passenger("Bill", false);
        Engine engine = new Engine(false, 150);
        Price price = new Price(15000);
        Transmission transmission = new Transmission(false);
        Auto auto = new Auto("Toyota corolla", transmission, price, engine, passengers);
        JAXBContext jaxbContext = JAXBContext.newInstance(Auto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = null;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(auto, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (StringReader stringReader = new StringReader(result)) {
            Auto autoUnmarshall = (Auto) unmarshaller.unmarshal(stringReader);
            System.out.println(autoUnmarshall.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        }

}

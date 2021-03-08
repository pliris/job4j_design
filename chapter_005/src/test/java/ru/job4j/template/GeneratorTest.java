package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {
//    @Test
//    public void produce() throws KeyNotException {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Nikita");
//        map.put("subject", "you");
//        assertEquals("I am a Nikita, Who are you? ", generator.produce(template, map));
//    }

//    @Test(expected = KeyNotException.class)
//    public void produceWhenNotKeyMapThenException() throws KeyNotException {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? I don't speak ${language}. ";
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Nikita");
//        map.put("subject", "you");
//        assertEquals("I am a Nikita, Who are you? I don't speak English. ", generator.produce(template, map));
//    }
//    @Test(expected = KeyNotException.class)
//    public void produceWhenExcessKeyInMapThenException() throws KeyNotException {
//        Generator generator = new GeneratorTemplate();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Nikita");
//        map.put("subject", "you");
//        map.put("language", "English");
//        assertEquals("I am a Nikita, Who are you? ", generator.produce(template, map));
//    }


}
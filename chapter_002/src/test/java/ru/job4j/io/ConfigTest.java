package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("./app.properties")).getFile());
        Config config = new Config(file.getAbsolutePath());
        config.load();
        assertThat(
                config.value("jdbc.username"),
                is("postgres")
        );
    }
}
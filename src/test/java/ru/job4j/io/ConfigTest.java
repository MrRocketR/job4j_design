package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "D:\\projects\\job4j_design\\app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("username"), is("postgres"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
        assertThat(config.value("driver_class"), is("org.postgresql.Driver"));
    }
}
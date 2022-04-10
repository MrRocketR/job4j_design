package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }
    @Test(expected = Config.IncorrectKeyValueException.class)
    public void whenException() {
        String path = "exception.properties";
        Config config = new Config(path);
        config.load();
    }
}
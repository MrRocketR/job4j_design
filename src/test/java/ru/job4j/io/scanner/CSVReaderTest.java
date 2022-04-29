package ru.job4j.io.scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;

public class CSVReaderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();


    @Test
    public void whenFilterTwoColumns() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        String[] params = {
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        };
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;age;",
                "Tom;20;",
                "Jack;25;",
                "William;30;"
        ).concat(System.lineSeparator());
        CSVReader.handle(params);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

    @Test
    public void whenStdout() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        Files.writeString(file.toPath(), data);
        String[] params = {"-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=stdout", "-filter=name,age"};
        CSVReader.main(params);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenWrongNumberOfArguments() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        Files.writeString(file.toPath(), data);
        String[] params = {"-delimiter=;", "-out=stdout", "-filter=name,age"};
        CSVReader.main(params);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenWrongDirectory() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        Files.writeString(file.toPath(), data);
        String[] params = {"-path=wrong.csv", "-delimiter=;", "-out=stdout", "-filter=name,age"};
        CSVReader.main(params);
    }


}
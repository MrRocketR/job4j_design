package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlJAXB {
    public static void main(String[] args) throws Exception {
        Character character = new Character(true, 225,
                "Loki", new String[] {"Staff", "Book"},
                new Rpg("warlock", 42));

        JAXBContext context = JAXBContext.newInstance(Character.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(character, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Character result = (Character) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}

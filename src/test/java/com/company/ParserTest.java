package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ParserTest {

    @Test
    public void parseTest() {
        try {
            List<Animal> animals = Parser.parse("src/test/java/com/company/test.txt");
            Assert.assertEquals(2, animals.size());
            Assert.assertEquals("ЛЕГКОЕ", animals.get(0).getProp("ВЕС"));
            Assert.assertEquals("ВЫСОКОЕ", animals.get(0).getProp("РОСТ"));
            Assert.assertEquals("ТРАВОЯДНОЕ", animals.get(0).getProp("ТИП"));
            Assert.assertEquals("ТЯЖЕЛОЕ", animals.get(1).getProp("ВЕС"));
            Assert.assertEquals("МАЛЕНЬКОЕ", animals.get(1).getProp("РОСТ"));
            Assert.assertEquals("ПЛОТОЯДНОЕ", animals.get(1).getProp("ТИП"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void getPropTest() {
        Animal animal = new Animal();
        animal.setProp("Test", "Best");
        Assert.assertEquals("Best", animal.getProp("Test"));
        Assert.assertEquals("null", animal.getProp("Alalal"));
    }
}

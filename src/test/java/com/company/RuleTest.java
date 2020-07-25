package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class RuleTest {
    @Test
    public void ruleTest() {
        try {
            Rule rule = new Rule("rule.txt");
            List<Animal> animals = Parser.parse("src/test/java/com/company/test.txt");
            Assert.assertEquals(1, rule.count(animals));
            rule = new Rule("src/test/java/com/company/falseRule.txt");
            Assert.assertEquals(0, rule.count(animals));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

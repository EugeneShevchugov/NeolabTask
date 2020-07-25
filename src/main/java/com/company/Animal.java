package com.company;

import java.util.HashMap;
import java.util.Map;

public class Animal {
    private Map<String, String> properties;

    public Animal() {
        properties = new HashMap<>();
    }

    public String getProp(String name) {
        return properties.getOrDefault(name, "null");
    }

    public void setProp(String name, String value) {
        properties.put(name, value);
    }
}

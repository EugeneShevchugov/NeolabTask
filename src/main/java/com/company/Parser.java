package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Parser {
    private Parser() {
    }

    public static List<Animal> parse(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File(fileName)));
        List<Animal> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            result.add(getAnimal(scanner.nextLine()));
        }
        return result;
    }

    public static Animal getAnimal(String props) {
        String[] propsArray = props.split(";");
        Animal animal = new Animal();
        for(String prop : propsArray) {
            String[] nameValue = prop.split("=");
            animal.setProp(nameValue[0], nameValue[1]);
        }
        return animal;
    }
}

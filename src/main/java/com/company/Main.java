package com.company;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        String fileRule = args[1];
        try {
            Rule rule = new Rule(fileRule);
            List<Animal> animals = Parser.parse(fileName);
            System.out.println(rule.count(animals));
        } catch (IOException e) {
            System.out.println("Ошибка выполнения");
        }
    }
}

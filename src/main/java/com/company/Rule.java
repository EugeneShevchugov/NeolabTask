package com.company;

import com.company.expressions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Rule {
    private Expression expression;

    public Rule(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File(fileName)));
        Stack<Expression> stack = new Stack<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            Expression expression;
            expression = getExpression(stack, s);
            stack.push(expression);
        }
        if (stack.size() != 1) {
            throw new IllegalStateException();
        }
        expression = stack.pop();
    }

    public int count(List<Animal> animals) {
        return filter(animals).size();
    }

    private List<Animal> filter(List<Animal> animals) {
        return animals.stream()
                .filter((animal -> expression.calculate(animal).equals("true")))
                .collect(Collectors.toList());
    }

    private Expression getExpression(Stack<Expression> stack, String s) {
        Expression expression;
        switch (s) {
            case "&":
                expression = new AndExpression(stack.pop(), stack.pop());
                break;
            case "|":
                expression = new OrExpression(stack.pop(), stack.pop());
                break;
            case "*":
                expression = new RelinkExpression(stack.pop());
                break;
            case "=":
                expression = new EqualsExpression(stack.pop(), stack.pop());
                break;
            case "!=":
                expression = new NotEqualsExpression(stack.pop(), stack.pop());
                break;
            default:
                expression = new ValueExpression(s);
                break;
        }
        return expression;
    }
}

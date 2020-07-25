package com.company.expressions;

import com.company.Animal;

public class NotEqualsExpression extends Expression {
    private Expression expression1;
    private Expression expression2;

    public NotEqualsExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public String calculate(Animal animal) {
        return !expression1.calculate(animal).equals(expression2.calculate(animal)) ? "true" : "false";
    }
}

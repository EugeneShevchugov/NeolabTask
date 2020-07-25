package com.company.expressions;

import com.company.Animal;

public class AndExpression extends Expression {
    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public String calculate(Animal animal) {
        if (expression1.calculate(animal).equals("false")) {
            return "false";
        }
        return expression2.calculate(animal);
    }
}

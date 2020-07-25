package com.company.expressions;

import com.company.Animal;

public class RelinkExpression extends Expression {
    private Expression expression;

    public RelinkExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String calculate(Animal animal) {
        return animal.getProp(expression.calculate(animal));
    }
}

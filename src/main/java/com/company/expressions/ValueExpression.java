package com.company.expressions;

import com.company.Animal;

public class ValueExpression extends Expression {
    private String value;

    public ValueExpression(String value) {
        this.value = value;
    }

    @Override
    public String calculate(Animal animal) {
        return value;
    }
}

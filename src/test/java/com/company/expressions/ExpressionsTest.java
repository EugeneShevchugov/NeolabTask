package com.company.expressions;

import com.company.Animal;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionsTest {
    @Test
    public void relinkExpressionTest() {
        Animal animal = new Animal();
        animal.setProp("Cow", "Okay");
        Expression expression = new RelinkExpression(new ValueExpression("Cow"));
        Assert.assertEquals("Okay", expression.calculate(animal));
        String value = animal.getProp("Caw");
        Assert.assertEquals("null", value);
    }

    @Test
    public void equalsExpressionTest() {
        Animal animal = new Animal();
        Expression value1 = new ValueExpression("Cow");
        Expression value2 = new ValueExpression("Caw");
        Expression expression = new EqualsExpression(value1, value1);
        Assert.assertEquals("true", expression.calculate(animal));
        expression = new EqualsExpression(value1, value2);
        Assert.assertEquals("false", expression.calculate(animal));
    }

    @Test
    public void notEqualsExpressionTest() {
        Animal animal = new Animal();
        Expression expression = new NotEqualsExpression(new ValueExpression("Cow"), new ValueExpression("Cow"));
        Assert.assertEquals("false", expression.calculate(animal));
        expression = new NotEqualsExpression(new ValueExpression("Cow"), new ValueExpression("Caw"));
        Assert.assertEquals("true", expression.calculate(animal));
    }

    @Test
    public void orExpressionTest() {
        Animal animal = new Animal();
        Expression expressionTrue = new EqualsExpression(new ValueExpression("Cow"), new ValueExpression("Cow"));
        Expression expressionFalse = new EqualsExpression(new ValueExpression("Caw"), new ValueExpression("Cow"));
        Expression orExpression = new OrExpression(expressionFalse, expressionFalse);
        Assert.assertEquals("false", orExpression.calculate(animal));
        orExpression = new OrExpression(expressionFalse, expressionTrue);
        Assert.assertEquals("true", orExpression.calculate(animal));
        orExpression = new OrExpression(expressionTrue, expressionFalse);
        Assert.assertEquals("true", orExpression.calculate(animal));
        orExpression = new OrExpression(expressionTrue, expressionTrue);
        Assert.assertEquals("true", orExpression.calculate(animal));
    }

    @Test
    public void andExpressionTest() {
        Animal animal = new Animal();
        Expression expressionTrue = new EqualsExpression(new ValueExpression("Cow"), new ValueExpression("Cow"));
        Expression expressionFalse = new EqualsExpression(new ValueExpression("Caw"), new ValueExpression("Cow"));
        Expression andExpression = new AndExpression(expressionFalse, expressionFalse);
        Assert.assertEquals("false", andExpression.calculate(animal));
        andExpression = new AndExpression(expressionFalse, expressionTrue);
        Assert.assertEquals("false", andExpression.calculate(animal));
        andExpression = new AndExpression(expressionTrue, expressionFalse);
        Assert.assertEquals("false", andExpression.calculate(animal));
        andExpression = new AndExpression(expressionTrue, expressionTrue);
        Assert.assertEquals("true", andExpression.calculate(animal));
    }

    @Test
    public void valueExpressionTest() {
        Animal animal = new Animal();
        Expression expression = new ValueExpression("Cow");
        Assert.assertEquals("Cow", expression.calculate(animal));
    }
}

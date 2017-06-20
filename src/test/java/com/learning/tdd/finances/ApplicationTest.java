package com.learning.tdd.finances;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void testMultiplication(){

        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assert.assertEquals(10, product.amount);

        product = five.times(3);
        Assert.assertEquals(15, product.amount);
    }

    @Test
    public void testEquality(){

        Assert.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}

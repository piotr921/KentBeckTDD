package com.learning.tdd.fibonacci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @Before
    public void before(){fibonacci = new Fibonacci();
    }

    @Test
    public void shouldReturnCorrectValueOfFibonacciElement(){

        Assert.assertEquals(0, fibonacci.getElement(0));
        Assert.assertEquals(1, fibonacci.getElement(1));
        Assert.assertEquals(55, fibonacci.getElement(10));
    }
}

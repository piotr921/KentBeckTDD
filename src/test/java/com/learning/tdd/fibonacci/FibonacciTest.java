package com.learning.tdd.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void shouldReturnZeroForZerothElement(){

        // Given
        Fibonacci fibonacci = new Fibonacci();
        // Assert
        Assert.assertEquals(0, fibonacci.getElement(0));
    }

    @Test
    public void shouldReturnOneForFirstElement(){

        // Given
        Fibonacci fibonacci = new Fibonacci();
        // Assert
        Assert.assertEquals(1, fibonacci.getElement(1));
    }

    @Test
    public void shouldReturnFiftyFiveForTenthElement(){

        // Given
        Fibonacci fibonacci = new Fibonacci();
        // Assert
        Assert.assertEquals(55, fibonacci.getElement(10));
    }
}

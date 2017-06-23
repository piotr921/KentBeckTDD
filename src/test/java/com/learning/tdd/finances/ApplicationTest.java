package com.learning.tdd.finances;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void testDollarMultiplication(){

        Money five = Money.dollar(5);
        Assert.assertEquals(Money.dollar(10), five.times(2));
        Assert.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality(){

        Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));

        Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){

        Assert.assertEquals("USD", Money.dollar(1).currency());
        Assert.assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){

        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney(){

        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assert.assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        Assert.assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        Assert.assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){

        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        Assert.assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {

        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes(){

        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(20), result);
    }
}

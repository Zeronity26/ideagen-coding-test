package com.ideagen.test;

import com.ideagen.test.utils.CalculatorUtil;

public class Main {

    public static void main(String[] args){
        assertEquals(CalculatorUtil.calculate("1 + 1"),2d,"1 + 1");
        assertEquals(CalculatorUtil.calculate("2 * 2"),4d,"2 * 2");
        assertEquals(CalculatorUtil.calculate("1 + 2 + 3"),6d,"1 + 2 + 3");
        assertEquals(CalculatorUtil.calculate("6 / 2"),3d,"6 / 2");
        assertEquals(CalculatorUtil.calculate("11 + 23"),34d,"11 + 23");
        assertEquals(CalculatorUtil.calculate("11.1 + 23"),34.1d,"11.1 + 23");
        assertEquals(CalculatorUtil.calculate("1 + 1 * 3"),4d,"1 + 1 * 3");
        assertEquals(CalculatorUtil.calculate("( 11.5 + 15.4 ) + 10.1"),37d,"( 11.5 + 15.4 ) + 10.1");
        assertEquals(CalculatorUtil.calculate("23 - ( 29.3 - 12.5 )"),6.2d,"23 - ( 29.3 - 12.5 )");
        assertEquals(CalculatorUtil.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )"),2d,"10 - ( 2 + 3 * ( 7 - 5 ) )");
        //additional test case
        assertEquals(CalculatorUtil.calculate("6 / 3 + 2 / 2"),3d,"6 / 3 + 2 / 2");
        assertEquals(CalculatorUtil.calculate("2 * 3 - 4 / 2"),4d,"2 * 3 - 4 / 2");
        assertEquals(CalculatorUtil.calculate("5 - 6 / 3 * 2"),1d,"5 - 6 / 3 * 2");
        assertEquals(CalculatorUtil.calculate("2 + 2 * 2 / 4"),3d,"2 + 2 * 2 / 4");
        assertEquals(CalculatorUtil.calculate("2 * ( 10.5 + 12.2 + 0.8 )"),47d,"2 * ( 10.5 + 12.2 + 0.8)");
        assertEquals(CalculatorUtil.calculate("5.5 - ( 1.2 + 5.5 / 5 )"),3.2d,"5.5 - ( 1.2 + 5.5 / 5 )");
        assertEquals(CalculatorUtil.calculate("( 2 + 3 ) / ( 2 - 1 )"),5d,"( 2 + 3 ) / ( 2 - 1 )");
        assertEquals(CalculatorUtil.calculate("( 3.3 - 1.1 ) / 2"),1.1d,"( 3.3 - 1.1 ) / 2");
        assertEquals(CalculatorUtil.calculate("( 10.5 - 2.5 * ( 6 - 2 ) ) / 2"),0.25d,"( 10.5 - 2.5 * ( 6 - 2 ) ) / 2");
        assertEquals(CalculatorUtil.calculate("2 * ( ( 5 + 5 ) - 2.5 * ( 3 - 2 ) )"),15d,"2 * ( ( 5 + 5 ) - 2.5 * ( 3 - 2 ) )");
    }

    private static void assertEquals(double actual, double expected, String message) {
        if (expected != actual) {
            throw new AssertionError(String.format("Calculation Error for \"%s\". Expected was %s, actual was %s", message, expected, actual));
        }
        System.out.printf("%s = %s%n", message, actual);
    }
}

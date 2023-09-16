package com.ideagen.test.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalculatorUtil {

    private CalculatorUtil() {}

    private static final List<String> HIGHEST_PRECEDENCE_OPERATOR = List.of("*","/");
    private static final int DEFAULT_SCALE = 2;

    public static boolean isNumeric(String str) {
        return str.matches("^[0-9]\\d*(\\.\\d+)?$");
    }

    public static boolean isOpenBracket(String str){
        return "(".equals(str);
    }

    public static boolean isCloseBracket(String str){
        return ")".equals(str);
    }

    public static boolean isBracket(String str) {
        return isOpenBracket(str) || isCloseBracket(str);
    }

    public static BigDecimal applyOperator(String previousOperand, String nextOperand, String operator, int scale){
        return applyOperator(new BigDecimal(previousOperand), new BigDecimal(nextOperand), operator, scale);
    }

    public static BigDecimal applyOperator(BigDecimal previousOperand, BigDecimal nextOperand, String operator, int scale){
        return switch(operator){
            case "+" -> previousOperand.add(nextOperand);
            case "-" -> previousOperand.subtract(nextOperand);
            case "*" -> previousOperand.multiply(nextOperand);
            case "/" -> previousOperand.divide(nextOperand, scale, RoundingMode.HALF_DOWN);
            default -> throw new IllegalArgumentException("Invalid operator input!");
        };
    }

    public static double calculate(String sum){
        return calculate(sum, DEFAULT_SCALE);
    }

    public static double calculate(String sum, int scale){
        Deque<String> operandStack = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();
        String[] strArray = sum.split(" ");

        for(String str: strArray){
            if(!operatorStack.isEmpty() && HIGHEST_PRECEDENCE_OPERATOR.contains(operatorStack.getFirst()) && isNumeric(str) && isNumeric(operandStack.getFirst())){
                operandStack.push(applyOperator(operandStack.pop(), str, operatorStack.pop(), scale).toString());
                continue;
            }

            if(isNumeric(str) || isBracket(str)) {
                operandStack.push(str);
            } else operatorStack.push(str);

            if(isCloseBracket(operandStack.getFirst())){
                operandStack.pop(); // remove close bracket from the stack
                String nextOperand = operandStack.pop();
                while(!isOpenBracket(operandStack.getFirst())){
                    nextOperand = applyOperator(operandStack.pop(), nextOperand, operatorStack.pop(), scale).toString();
                }
                operandStack.pop(); // remove open bracket from the stack
                operandStack.push(nextOperand);
            }
        }

        while(!operatorStack.isEmpty()){
            BigDecimal result = applyOperator(operandStack.removeLast(), operandStack.removeLast(), operatorStack.removeLast(), scale);
            operandStack.addLast(result.toString());
        }

        return Double.parseDouble(operandStack.pop());
    }
}

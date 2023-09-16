# Summary

Time used for this coding test : 2 hours

Solution:
1) created a utility class to purposely handle all the calculation related stuff in order to make the code more readable and reusable
2) Introduced isNumeric method to check whether the string is numeric or not
3) Introduced isOpenBracket method to check whether the string is open bracket or not
4) Introduced isCloseBracket method to check whether the string is close bracket or not
5) Introduced isBracket method to check whether the string is a bracket or not
6) Introduced applyOperator method to perform calculation on two provided operand based on given operator. Use BigDecimal class instead of double to perform calculation to avoid floating point errors. 
7) Introduced calculate method to evaluate the math expression and generate result based on it
<br>Procedure:
    - Declare two stack variables initially, one of them is used to store operand including bracket and another is used to store operator
    - Split the expression with space and assign to a variable. After that loop the variable to perform logic based on each element of the collection.
    - First, if operator stack is containing  multiply or divide operator and both current operand and previous operand is numeric, then it will perform calculation based on the current operand and previous operand. After that, push the result into the operand stack for further calculation and proceed to next element.
    - When above condition is not executed, will push element into operand stack if it is either numeric value or bracket, else will push it to operator stack.
    - Next, it will check whether the last element that pushed into operand stack is close bracket, if yes, then it will perform all the calculation within the bracket. After that, push the result that generated from the calculation into operand stack in order to replace the math expression within the bracket.
    - At the end, loop through the operator stack to perform calculation on remaining element from both operand stack and operator stack which has the lowest precedence(addition, subtraction)

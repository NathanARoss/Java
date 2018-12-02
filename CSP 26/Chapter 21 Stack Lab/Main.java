/**
 * This algorithm parses an expression and evaluates it.
 * It respects order of operations (but lacks exponent support).
 * It ignores extra whitespace i.e. 4 - 1 == 4-1
 * It permits negative values inside or outside parenthesis i.e. 4--1 == 4-(-1) == 4 - -1
 * It even permits explicitly positive values i.e. 4-(+1) and 4 - +1
 *
 * Please don't enter unmatched parenthesis or otherwise invalid expressions.  It doesn't fail gracefully
 *
 * Written by Nathan Ross
 * Last edited 4-11-2018
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String OPERATOR_LIST = "(+-*/)";

    public static void main(String [] args) {
        Stack<Character> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        //numbers can span multiple characters
        StringBuilder number = new StringBuilder();

        System.out.print("Enter an expression: ");

        Scanner keyboard = new Scanner(System.in);
        String expression = keyboard.nextLine();

        //remove whitespace and add parenthesis to force the final evaluation
        String wrappedExpression = '(' + expression.replaceAll("\\s", "") + ')';

        for (int i = 0, n = wrappedExpression.length(); i < n; ++i) {
            char c = wrappedExpression.charAt(i);

            if (OPERATOR_LIST.indexOf(c) >= 0) {
                //a '-' or '+' immediately succeeding another operator is treated as the start of a signed number
                if ((c == '-' || c == '+') && OPERATOR_LIST.indexOf(wrappedExpression.charAt(i - 1)) >= 0) {
                    number.append(c);
                }
                else {
                    //operators delimit numbers since a number can span multiple characters
                    if (number.length() > 0) {
                        operands.push(Double.parseDouble(number.toString()));
                        number.setLength(0);

                        //multiplication and division can take place immediately without waiting for a )
                        if (operators.peek() == '*' || operators.peek() == '/') {
                            char operator = operators.pop();
                            double op2 = operands.pop();
                            double op1 = operands.pop();
                            double result;
                            if (operator == '*') {
                                result = op1 * op2;
                            } else {
                                result = op1 / op2;
                            }
                            operands.push(result);
                        }
                    }

                    //reduce everything between ( ) to a single value
                    if (c == ')') {
                        //everything between ( ) are + and - because * and / are handled as the numbers are parsed
                        double sum = 0.0;

                        char operator;
                        do {
                            operator = operators.pop();
                            double operand = operands.pop();

                            //explicitly subtraction.  Negative numbers are handled during number parsing
                            if (operator == '-') {
                                sum -= operand;
                            }
                            //handle addition as well as the first number after '('
                            else {
                                sum += operand;
                            }
                        } while (operator != '(');

                        operands.push(sum);
                    } else {
                        //')' symbol is consumed as soon as it is encountered, so it is never pushed
                        operators.push(c);
                    }
                }
            } else if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else {
                System.out.printf("Unrecognized symbol: %s%n", c);
            }
        }

        System.out.printf("%s == %f%n", expression, operands.pop());
    }
}

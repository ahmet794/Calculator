package uk.ac.rhul.cs2800;


/**
 * Allows calculation of the String expressions.
 * 
 * @author ahmet
 *
 */
public interface Calculator {
  /**
   * This method takes a string parameter and evaluates the entered expression.
   * 
   * @param str is expression to be calculated.
   * @return the result of the calculation.
   * @throws InvalidExpression when the expression is invalid.
   * @throws BadTypeException when the stack is used.
   */
  public float evaluate(String str) throws InvalidExpression, BadTypeException;

  /**
   * This method checks if the expression is infix.
   * 
   * @param exp is the expression.
   * @return if it is an infix expression.
   */
  public boolean isInfix(String exp);

}

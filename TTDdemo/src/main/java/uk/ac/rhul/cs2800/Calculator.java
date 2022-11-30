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
   */
  public float evaluate(String str) throws InvalidExpression;

}

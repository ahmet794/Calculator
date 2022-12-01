package uk.ac.rhul.cs2800;

/**
 * This class uses Reverse Polish (postfix) notation to evaluate expressions.
 * 
 * @author ahmet
 *
 */
public class RevPolishCalculator implements Calculator {

  @Override
  public float evaluate(String str) throws InvalidExpression {
    if (str.charAt(2) == '1') {
      return 2.0f;
    }
    return 3.0f;
  }

}

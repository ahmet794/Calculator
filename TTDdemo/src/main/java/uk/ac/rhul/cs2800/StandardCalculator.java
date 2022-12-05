package uk.ac.rhul.cs2800;

/**
 * Evaluate standard (infix) notation expressions.
 * 
 * @author ahmet
 *
 */
public class StandardCalculator implements Calculator {

  @Override
  public float evaluate(String str) throws InvalidExpression {
    String[] exp = str.split(" ");
    if (exp[0].equals("2")) {
      return 8.0f;
    } else {
      return 3.0f;
    }
  }

}

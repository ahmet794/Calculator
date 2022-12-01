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
    String[] exp = str.split(" ");
    float sum = 0;
    float val = 0;
    for (int i = 0; i < exp.length - 1; i++) {
      val = Float.parseFloat(exp[i]);
      sum += val;
    }
    return sum;
  }
}

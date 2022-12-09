package uk.ac.rhul.cs2800;

/**
 * The calculator to use it in the GUI.
 * 
 * @author ahmet
 *
 */
// This code is inspired by Dave's many many examples, MVC-separated.
public final class CalcModel {

  RevPolishCalculator postfix;

  private CalcModel() {
    postfix = new RevPolishCalculator();
  }

  private static CalcModel instance = null;

  /**
   * This method creates an access to the singleton that we created before.
   * 
   * @return the instance.
   */
  public static CalcModel getInstance() {
    if (instance == null) {
      instance = new CalcModel();
    }
    return instance;
  }

  /**
   * This method should calculate the given expression. It now only will return 17.00 for now.
   * 
   * @param text is the expression.
   * @return the result.
   * @throws BadTypeException if the wrong type of getter is called.
   * @throws InvalidExpression if an invalid expression is typed.
   */
  public float calculate(String text) throws InvalidExpression, BadTypeException {
    return postfix.evaluate(text);
  }
}

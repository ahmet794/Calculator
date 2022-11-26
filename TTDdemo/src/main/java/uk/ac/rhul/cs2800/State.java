package uk.ac.rhul.cs2800;

/**
 * This is an interface for the all states that the menu can be in.
 * 
 * @author ahmet
 *
 */

public interface State {
  /**
   * The method to calculate the expression.
   * 
   */
  public void calculate();

  /**
   * The method to change the calculator type to postfix.
   * 
   */
  public void postfix();

  /**
   * The method to change the calculator type to infix.
   */
  public void infix();

  /**
   * The method to set the expression to be calculated.
   * 
   * @param exp is the expression.
   */
  public void setExpression(String exp);

  /**
   * The method to exit the menu.
   */
  public void quit();
}

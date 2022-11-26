package uk.ac.rhul.cs2800;

/**
 * This state is the state where the expression is asked to the user.
 * 
 * @author ahmet
 *
 */
public class ExpressionState implements State {

  private String expression;

  /**
   * This constructor takes a Menu object to create an ExpressionState object.
   * 
   * @param menu is the menu object.
   */
  public ExpressionState(Menu menu) {

  }

  @Override
  public void calculate() {

  }


  @Override
  public void setExpression(String exp) {
    expression = exp;

  }

  @Override
  public void quit() {

  }

  @Override
  public void postfix() {

  }

  @Override
  public void infix() {

  }

}

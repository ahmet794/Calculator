package uk.ac.rhul.cs2800;

/**
 * This state is the state where the expression is asked to the user.
 * 
 * @author ahmet
 *
 */
public class ExpressionState implements State {

  private String expression;
  private Menu menu;

  /**
   * This constructor takes a Menu object to create an ExpressionState object.
   * 
   * @param menu is the menu object.
   */
  public ExpressionState(Menu menu) {

  }

  @Override
  public void calculate() {
    System.out.println("This class only calls the setExpression method.");
  }


  @Override
  public void setExpression(String exp) {
    expression = exp;
    menu.changeState(new CalculateState());

  }

  @Override
  public void quit() {
    System.out.println("This class only calls the setExpression method.");
  }

  @Override
  public void postfix() {
    System.out.println("This class only calls the setExpression method.");
  }

  @Override
  public void infix() {
    System.out.println("This class only calls the setExpression method.");
  }

}

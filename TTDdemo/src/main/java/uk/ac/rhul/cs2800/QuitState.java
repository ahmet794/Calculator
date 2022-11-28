package uk.ac.rhul.cs2800;

/**
 * This class is used for menu to be quit.
 * 
 * @author ahmet
 *
 */
public class QuitState implements State {

  private Menu menu;

  /**
   * This constructor creates a Menu object to be used in its quit method.
   * 
   * @param menu is the Menu object.
   */
  public QuitState(Menu menu) {
    this.menu = menu;
  }

  @Override
  public void calculate() {
    System.out.println("This class only calls the quit method.");
  }

  @Override
  public void postfix() {
    System.out.println("This class only calls the quit method.");
  }

  @Override
  public void infix() {
    System.out.println("This class only calls the quit method.");
  }

  @Override
  public void setExpression(String exp) {
    System.out.println("This class only calls the quit method.");
  }

  @Override
  public void quit() {
    menu.setFinished(true);
  }

}

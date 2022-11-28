package uk.ac.rhul.cs2800;

/**
 * This state is the state where the calculator calculates.
 * 
 * @author ahmet
 *
 */
public class CalculateState implements State {

  private Observer calculator = null;

  @Override
  public void calculate() {
    calculator.notifyObservers();

  }


  @Override
  public void setExpression(String exp) {
    System.out.println("This class only calls the calculate method.");

  }

  @Override
  public void quit() {
    System.out.println("This class only calls the calculate method.");
  }



  @Override
  public void postfix() {
    System.out.println("This class only calls the calculate method.");
  }



  @Override
  public void infix() {
    System.out.println("This class only calls the calculate method.");
  }

}

package uk.ac.rhul.cs2800;

/**
 * This state is the state where the calculator calculates.
 * 
 * @author ahmet
 *
 */
public class CalculateState implements State {

  Observer calculator = null;

  @Override
  public void calculate() {
    calculator.notifyObservers();

  }


  @Override
  public void setExpression(String exp) {


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

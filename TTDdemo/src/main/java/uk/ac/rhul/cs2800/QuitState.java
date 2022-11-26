package uk.ac.rhul.cs2800;

/**
 * This class is used for menu to be quit.
 * 
 * @author ahmet
 *
 */
public class QuitState implements State {

  boolean finished;

  @Override
  public void calculate() {

  }

  @Override
  public void postfix() {

  }

  @Override
  public void infix() {

  }

  @Override
  public void setExpression(String exp) {

  }

  @Override
  public void quit() {
    finished = true;

  }

}

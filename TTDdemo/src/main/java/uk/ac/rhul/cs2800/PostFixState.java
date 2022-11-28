package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * This state is the state where the calculator changes type to postfix.
 * 
 * @author ahmet
 *
 */
public class PostFixState implements State {
  

  private Consumer<OpType> type;

  @Override
  public void calculate() {
    System.out.println("This class only calls the postfix method.");
  }


  @Override
  public void setExpression(String exp) {
    System.out.println("This class only calls the postfix method.");
  }

  @Override
  public void quit() {
    System.out.println("This class only calls the postfix method.");
  }


  @Override
  public void postfix() {
    type.accept(OpType.POSTFIX);

  }


  @Override
  public void infix() {
    System.out.println("This method only calls the postfix method.");
  }

}

package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * This state is the state where the calculator changes type to infix.
 * 
 * @author ahmet
 *
 */
public class Infix implements State {

  private Consumer<OpType> type;

  @Override
  public void calculate() {
    System.out.println("This class oonly calls the infix method.");
  }

  @Override
  public void postfix() {
    System.out.println("This class oonly calls the infix method.");
  }

  @Override
  public void infix() {
    type.accept(OpType.INFIX);

  }

  @Override
  public void setExpression(String exp) {
    System.out.println("This class oonly calls the infix method.");
  }

  @Override
  public void quit() {
    System.out.println("This class oonly calls the infix method.");
  }

}

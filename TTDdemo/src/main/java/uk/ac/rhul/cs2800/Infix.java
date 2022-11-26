package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * This state is the state where the calculator changes type to infix.
 * 
 * @author ahmet
 *
 */
public class Infix implements State {

  Consumer<OpType> type;

  @Override
  public void calculate() {

  }

  @Override
  public void postfix() {

  }

  @Override
  public void infix() {
    type.accept(OpType.INFIX);

  }

  @Override
  public void setExpression(String exp) {

  }

  @Override
  public void quit() {

  }

}

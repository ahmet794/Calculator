package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * This state is the state where the calculator changes type to postfix.
 * 
 * @author ahmet
 *
 */
public class PostFixState implements State {

  Consumer<OpType> type;

  @Override
  public void calculate() {


  }


  @Override
  public void setExpression(String exp) {


  }

  @Override
  public void quit() {


  }


  @Override
  public void postfix() {
    type.accept(OpType.POSTFIX);

  }


  @Override
  public void infix() {

  }

}

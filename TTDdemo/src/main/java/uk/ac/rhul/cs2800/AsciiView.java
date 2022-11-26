
package uk.ac.rhul.cs2800;

/*
 * This code was inspired by the code at Dave's many many examples, MVC-seperated.
 */
import java.util.function.Consumer;

/**
 * This class creates a menu based view.
 * 
 * @author ahmet
 *
 */

public class AsciiView implements ViewInterface {

  String expression;
  Observer calculator = null;
  Consumer<OpType> type = null;


  /**
   * The menu that is created for the calculator. This method will use a State design pattern.
   * 
   */
  public void menu() {

  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    System.out.println("Almost there!");

  }


  @Override
  public void addTypeObserver(Consumer<OpType> selectedType) {
    type = selectedType;

  }

  @Override
  public void addCalcObserver(Observer runnable) {
    calculator = runnable;    
  }

  

}

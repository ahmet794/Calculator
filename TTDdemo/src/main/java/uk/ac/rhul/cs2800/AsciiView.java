
package uk.ac.rhul.cs2800;

import java.util.Scanner;
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
  Calculator calc;
  Consumer<OpType> type = null;


  /**
   * The menu that is created for the calculator.
   * 
   * @throws BadTypeException if the wrong getter is called.
   * @throws InvalidExpression if there is an invalid expression.
   * 
   */
  public void menu() throws InvalidExpression, BadTypeException {
    Scanner s = new Scanner(System.in);
    calc = new RevPolishCalculator();
    boolean finished = false;
    boolean postfix = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.charAt(0)) {
        case 'C':
        case 'c':
          if (calculator != null) {
            calculator.notifyObservers();
            if (postfix == true) {
              calc.evaluate(expression);
            }
          }
          break;
        case 'I':
        case 'i':
          if (type != null) {
            type.accept(OpType.INFIX);
            postfix = false;
          }
          break;
        case 'P':
        case 'p':
          if (type != null) {
            type.accept(OpType.POSTFIX);
            postfix = true;
          }
          break;
        case '?':
          expression = t.substring(1);
          System.out.println("Expression is: " + expression);
          break;
        case 'Q':
        case 'q':
          System.out.println("See you!");
          break;
        default:
          help();
          break;
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following: \n " + "Use '?' to set the expression. \n "
        + "Use 'P' to change to Postfix. \n " + "Use 'I' to change to infix. \n "
        + "Use 'C' to calculate. \n Use 'Q' to exit the program.");

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

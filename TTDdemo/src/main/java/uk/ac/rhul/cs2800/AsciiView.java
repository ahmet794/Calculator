
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
  Consumer<OpType> type = null;
  private String answer;


  /**
   * The menu that is created for the calculator.
   * 
   * @throws BadTypeException if the wrong getter is called.
   * @throws InvalidExpression if there is an invalid expression.
   * 
   */
  public void menu() throws InvalidExpression, BadTypeException {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.charAt(0)) {
        case 'C':
        case 'c':
          if (calculator != null) {
            calculator.notifyObservers();
            System.out.println("Answer is " + answer);
          }
          break;
        case 'I':
        case 'i':
          if (type != null) {
            type.accept(OpType.INFIX);
          }
          break;
        case 'P':
        case 'p':
          if (type != null) {
            type.accept(OpType.POSTFIX);
          }
          break;
        case '?':
          expression = s.nextLine().trim();
          calculator.notifyObservers();
          System.out.println("Expression is: " + expression);
          break;
        case 'Q':
        case 'q':
          System.out.println("See you!");
          finished = true;
          break;
        default:
          help();

          break;
      }
    }
    s.close();

  }

  private void help() {
    System.out.println("Use one of the following: \n "
        + "Use '?' to set the expression. Type the expresssion with leaving spaces "
        + "in between characters. \n " + "Use 'P' to change to Postfix. \n "
        + "Use 'I' to change to infix. \n "
        + "Use 'C' to calculate. \n Use 'Q' to exit the program.");

  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(String str) {
    answer = str;
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

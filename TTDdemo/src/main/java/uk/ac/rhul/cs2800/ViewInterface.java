package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * The interface to create AsciiView and GUIView classes.
 * 
 * @author ahmet
 */
public interface ViewInterface {
  /**
   * A getter for expressions.
   * 
   * @return the expression.
   */
  public String getExpression();

  /**
   * A setter for answer.
   * 
   * @param str is the string to set the answer as.
   */
  public void setAnswer(String str);

  /**
   * Adding a Runnable to the observer.
   * 
   * @param runnable is the Runnable that is added.
   */
  public void addCalcObserver(Runnable runnable);

  /**
   * Adding the which method to be used in the calculator.
   * 
   * @param consumer is the method used.
   */
  public void addTypeObserver(Consumer<OpType> consumer);

}

package uk.ac.rhul.cs2800;

/**
 * The Shunting algorithm requires reversing tan expression in order to evaluate left to right. So
 * we provide a face to hide details.
 * 
 * @author ahmet
 *
 */

public class StrStack {

  private Stack strStack;

  /**
   * This constructor creates a StrStack object which takes a Stack object.
   * 
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * This method adds a string to the string stack.
   * 
   * @param string is the string that is added to the stack.
   */
  public void push(EntryInt string) {
    strStack.push(string);
  }

  /**
   * This method removes the last element on the stack.
   * 
   * @return the element that is removed.
   * @throws BadTypeException can never be actually thrown.
   */
  public String pop() throws BadTypeException {
    return strStack.pop().getString();
  }

  /**
   * This method should give the element that is on the top of the stack.
   * 
   * @return the last element that is pushed.
   * @throws BadTypeException can never be actually thrown.
   */
  public String top() throws BadTypeException {
    return strStack.top().getString();
  }



}

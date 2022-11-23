package uk.ac.rhul.cs2800;


/**
 * We facade the details by creating the OpStack class which creates Stacks that only takes Symbol
 * ENUM.
 * 
 * @author ahmet
 *
 */
public class OpStack {

  private Stack opStack;

  /**
   * This constructor creates a Stack object.
   * 
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * This method adds elements to the stack.
   * 
   * @param symbol is the ENUM that is added to the stack.
   */
  public void push(EntryInt symbol) {
    opStack.push(symbol);
  }

  /**
   * This method removes the last element that was pushed into the stack.
   * 
   * @return the removed the element.
   * @throws BadTypeException is never thrown.
   */
  // BadTypeException will never be thrown because type is already defined.
  public Symbol pop() throws BadTypeException {
    return opStack.pop().getOp();
  }



}

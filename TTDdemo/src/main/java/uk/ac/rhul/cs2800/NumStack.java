package uk.ac.rhul.cs2800;

/**
 * We facade the details by creating the NumStack class which creates Stacks that only takes floats.
 * 
 * @author ahmet
 *
 */
public class NumStack {

  private Stack numStack;

  /**
   * This constructor creates a Stack object.
   * 
   */
  public NumStack() {

    numStack = new Stack();
  }

  /**
   * This method adds a float element to the stack.
   * 
   * @param value is the element that is added.
   */
  public void push(Entry value) {
    numStack.push(value);
  }

  /**
   * This method removes the last element in the stack.
   * 
   * @return the value of the removed element.
   * @throws BadTypeException will not throw.
   */
  // BadTypeException wont be thrown because the type is already defined.
  public float pop() throws BadTypeException {
    return numStack.pop().getNum();
  }

  /**
   * This method checks if the stack is empty or not.
   * 
   * @return a boolean depending on if the stack is empty or not.
   */
  public boolean isEmpty() {
    return numStack.size() == 0;
  }

  /**
   * This method gives the size of the stack.
   * 
   * @return the size.
   */
  public int size() {
    return numStack.size();
  }



}

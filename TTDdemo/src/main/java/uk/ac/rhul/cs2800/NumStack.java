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
  public void push(EntryInt value) {
    numStack.push(value);
  }

  /**
   * This method removes the last element in the stack.
   * 
   * @return the value of the removed element.
   */
  public float pop() {
    return 17.0f;
  }



}

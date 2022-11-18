package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This is a Stack class to create a stack which does basic stack commands.
 * 
 * @author ahmet
 *
 */

public class Stack {

  ArrayList<EntryInt> list = new ArrayList<EntryInt>();

  int size;

  /**
   * A method to get the value of the Stack size.
   * 
   * @return size of the stack
   */
  public int size() {
    return list.size();
  }

  /**
   * A method to add an element on top of the stack.
   * 
   * @param i is the value of the element.
   */
  public void push(EntryInt i) {
    list.add(i);
  }

  /**
   * A method to remove the latest added element to the stack and return the value of it.
   * 
   * @return the value of the removed element
   */
  public EntryInt pop() {
    if (list.size() == 0) {
      throw new EmptyStackException();
    }
    EntryInt value = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return value;
  }

  /**
   * This method should give the element that is on the top of the stack.
   * 
   * @return the value of the newest element.
   */
  public EntryInt top() {
    return list.get(list.size() - 1);
  }

}

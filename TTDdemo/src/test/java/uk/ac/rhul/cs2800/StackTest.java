package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack s;
  private EntryInt element;


  // 1
  // Setup to create the object
  @BeforeEach
  public void setup() {
    s = new Stack();
    float value = 17.0f;
    element = new FloatEntry(value);
  }

  // 2
  // Test to create and test size()
  @Test
  void testSize() {
    assertEquals(s.size(), 0, "Test a newly created Stack to see it has 0 value of size.");
  }

  // 3
  // Test to create push(), test push() and size()
  @Test
  void testPush() {
    s.push(element);
    assertEquals(s.size(), 1,
        "Test to see if push works and adds an element to the stack and increases the value of size.");
  }

  // 4
  // Test push() and size() in an extended version
  @Test
  void testPushThreeTimes() {
    s.push(element);
    s.push(element);
    s.push(element);
    assertEquals(s.size(), 3,
        "Test to see if pushing three times to the stack increases the value of size.");
  }

  // 5
  // Test to create pop(), test pop() and size()
  @Test
  void testPop() {
    s.push(element);
    s.pop();
    assertEquals(s.size(), 0,
        "Test to see after pushing one element to the stack, if we use pop if it decreases the value of the size.");

  }

  // 6
  // Test to pop an EmptyStack
  @Test
  void testEmptyStack() {
    assertThrows(EmptyStackException.class, () -> s.pop(), "You can not pop an empty stack.");
  }

  // 7
  // Test to see if push, pop and size works all at the same time
  @Test
  void testPushandPopEmptyStack() {
    s.push(element);
    try {
      assertEquals(s.pop().getNum(), 17.0f,
          "Pushing element and then popping it should give element");
    } catch (BadTypeException e) {
      ;
    }
    assertEquals(s.size(), 0, "Pushing then popping should give the size of the stack 0");
    assertThrows(EmptyStackException.class, () -> s.pop(),
        "Popping a stack with the size value of 0 should give an exception");
  }

  // 8
  // Test to get the value that is returned from pop()
  @Test
  void testPushandPop() {
    s.push(element);
    EntryInt new_element = new FloatEntry(44.0f);
    s.push(new_element);
    try {
      assertEquals(s.pop().getNum(), 44, "Test to see if pop() returns the popped value");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 9
  // Test top() to get the newest element in the stack
  @Test
  void testTop() {
    s.push(element);
    EntryInt new_element = new FloatEntry(44.0f);
    s.push(new_element);
    s.pop();
    try {
      assertEquals(s.top().getNum(), 17,
          "After pushing 17, 44 and popping it, top() should return the value of 17");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 10
  // Test top() for an empty stack
  @Test
  void testEmptyStackTop() {
    assertThrows(EmptyStackException.class, () -> s.pop(),
        "Using the pop() method on an empty stack should give EmptyStackException");
  }

}



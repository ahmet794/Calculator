package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {

  private NumStack numStack;
  private EntryInt value;

  @BeforeEach
  void setup() {
    numStack = new NumStack();
    value = new FloatEntry(17.0f);
  }

  // 1
  // Test and create the push method.
  @Test
  void testNumStackpush() {
    numStack.push(value);
  }

  // 2
  // Test push and also create the pop method and check for EmptyStackException.
  @Test
  void testNumStackpushAndpop() {
    numStack.push(value);
    try {
      assertEquals(numStack.pop(), 17.0f, "Pushing 17.0f and popping it should return 17.0f.");
    } catch (BadTypeException e) {
      ;
    }
    EntryInt two = new FloatEntry(2.0f);
    EntryInt three = new FloatEntry(3.0f);
    numStack.push(two);
    numStack.push(three);
    try {
      assertEquals(numStack.pop(), 3.0f, "Pushing two and three and popping it should return 3.0f");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 3
  // Testing the pop method for EmptyStackException.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "When the stack is empty when you use the pop method it should throw an exception.");
  }

  // 4
  // Test and create isEmpty method.
  @Test
  void testNumStackisEmpty() {
    assertEquals(numStack.isEmpty(), true,
        "When the stack is empty this method should return true.");
    numStack.push(value);
    assertEquals(numStack.isEmpty(), false,
        "When the stack is not empty this method should return false.");
  }



}

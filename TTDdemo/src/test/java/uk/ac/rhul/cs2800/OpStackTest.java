package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  private OpStack opStack;
  private EntryInt symbol;

  @BeforeEach
  void setup() {
    opStack = new OpStack();
    symbol = new OperationEntry(Symbol.DIVIDE);
  }

  // 1
  // Test and create the push method.
  @Test
  void testOpStackpush() {
    opStack.push(symbol);
  }

  // 2
  // Test and create the pop method which should remove the last element and return it.
  @Test
  void testOpStackpop() {
    opStack.push(symbol);
    try {
      assertEquals(opStack.pop(), Symbol.DIVIDE,
          "Pushing a DIVIDE ENUM and popping it should remove the pushed item and return it.");
    } catch (BadTypeException e) {
      ;
    }
    EntryInt plus = new OperationEntry(Symbol.PLUS);
    EntryInt minus = new OperationEntry(Symbol.MINUS);
    opStack.push(plus);
    opStack.push(minus);
    try {
      assertEquals(opStack.pop(), Symbol.MINUS,
          "Pushing plus and minus and popping should return the last pushed item which is minus.");
    } catch (BadTypeException e) {
      ;
    }

  }

  // 3
  // Test the EmptyStackException in the pop method.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(),
        "When there is nothing in the stack and pop method is used, it should throw an exception.");
    opStack.push(symbol);
    try {
      opStack.pop();
    } catch (BadTypeException e) {
      ;
    }
    assertThrows(EmptyStackException.class, () -> opStack.pop(),
        "When you push once and pop twice there is nothing left in the stack, it should throw an exception.");
  }

  // 4
  // Test and create the isEmpty method.
  @Test
  void testisEmpty() {
    assertEquals(opStack.isEmpty(), true,
        "When the stack is empty and isEmpty called, it should return true.");
  }


}

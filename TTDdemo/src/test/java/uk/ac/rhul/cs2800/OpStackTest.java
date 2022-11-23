package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
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


}

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
  

}

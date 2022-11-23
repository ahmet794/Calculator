package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
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
  

}

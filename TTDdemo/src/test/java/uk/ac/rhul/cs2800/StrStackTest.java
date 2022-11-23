package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {

  private StrStack strS;
  private EntryInt string;
  private Stack stack;

  @BeforeEach
  public void setup() {
    strS = new StrStack(stack);
    string = new StringEntry("One");
  }


  // 1
  @Test
  void testStrStackpush() {
    strS.push(string);
  }

}

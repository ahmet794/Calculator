package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {

  private StrStack strS;
  private EntryInt string;

  @BeforeEach
  public void setup() {
    strS = new StrStack();
    string = new StringEntry("One");
  }


  // 1
  // Test to creating the push method.
  @Test
  void testStrStackpush() {
    strS.push(string);
  }
  
  // 2
  // Testing push and pop at the same time. 
  @Test
  void testStrStackpopandpush() {
    strS.push(string);
    try {
      assertEquals(strS.pop(), "One", "Pushing a string and poppinh it should return the last string that was pushed.");
    } catch (BadTypeException e) {
      ;
    }
  }
  
  // 3
  // Testing two pushes and pop method. 
  @Test
  void testStrStackpop() {
    EntryInt str = new StringEntry("Two");
    strS.push(string);
    strS.push(str);
    try {
      assertEquals(strS.pop(), "Two");
    } catch (BadTypeException e) {
      ;
    }
    
  }

}

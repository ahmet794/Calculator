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
      assertEquals(strS.pop(), "One",
          "Pushing a string and poppinh it should return the last string that was pushed.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 3
  // Testing two pushes and and two pop methods.
  @Test
  void testStrStackpop() {
    EntryInt str = new StringEntry("Two");
    strS.push(string);
    strS.push(str);
    try {
      assertEquals(strS.pop(), "Two",
          "Pushing two times and popping it should return the last removed item.");
      assertEquals(strS.pop(), "One",
          "Popping the stack for the second time should return string and remove it.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 4
  // Test and create top method.
  @Test
  void testStrStacktop() {
    strS.push(string);
    EntryInt str = new StringEntry("Two");
    strS.push(str);
    try {
      assertEquals(strS.top(), "Two",
          "Pushing two times and using the top method should return the last item that was pushed.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 5
  // Testing the top method with more pushes.
  @Test
  void testStrStacktopandpush() {
    strS.push(string);
    EntryInt str = new StringEntry("Two");
    EntryInt three = new StringEntry("Three");
    strS.push(str);
    strS.push(three);
    try {
      assertEquals(strS.top(), "Three",
          "Pushing three times and calling the top method should return the last item that was pushed.");
    } catch (BadTypeException e) {
      ;
    }

  }



}



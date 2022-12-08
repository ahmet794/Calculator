package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {

  private StrStack strS;
  private Entry string;

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
    Entry str = new StringEntry("Two");
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
    Entry str = new StringEntry("Two");
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
    Entry str = new StringEntry("Two");
    Entry three = new StringEntry("Three");
    strS.push(str);
    strS.push(three);
    try {
      assertEquals(strS.top(), "Three",
          "Pushing three times and calling the top method should return the last item that was pushed.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 6
  // Testing the EmptyStacException in the pop method.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> strS.pop(),
        "Calling pop method without pushing anything to the stack should throw an EmptyStackException.");
  }

  // 7
  // Test and create the isEmpty method.
  @Test
  void testisEmpty() {
    assertEquals(strS.isEmpty(), true,
        "When there is no element that has been pushed isEmpty method should return true");
    strS.push(string);
    assertEquals(strS.isEmpty(), false,
        "If an element is pushed to the stack it should not be empty");
  }



}



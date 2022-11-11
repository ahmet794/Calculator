package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringEntryTest {

  private StringEntry strEntry;

  @BeforeEach
  public void setup() {
    strEntry = new StringEntry("One");
  }

  // 1
  // Use the StringEntry object to and get the string from using the getString method.
  @Test
  void testStringEntry() {
    assertEquals(strEntry.getString(), "One",
        "Creating an StringEntry object and using getString() should give back the string parameter.");
  }

  // 2
  // Use the StringEntry object to and get the string from using the getNum method.
  @Test
  void testStringEntryGetNum() {
    assertThrows(BadTypeException.class, () -> strEntry.getNum(),
        "Calling the getNum() method should throw an Exception.");
  }

  // 3
  // Use the StringEntry object to and get the string from using the getOp method.
  @Test
  void testStringEntryGetOp() {
    assertThrows(BadTypeException.class, () -> strEntry.getOp(),
        "Calling the getOp() method should throw an Exception.");
  }

}

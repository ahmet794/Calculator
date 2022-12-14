package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FloatEntryTest {

  private Entry floatEntry;
  private EntryFactory facEntry;

  @BeforeEach
  public void setup() {
    EntryFactory facEntry = new EntryFactory();
    floatEntry = facEntry.createEntry(17.0f);
  }

  // 1
  // Use the FloatEntry object and get the value from using the getNum method.
  @Test
  void testFloatEntry() {
    try {
      assertEquals(floatEntry.getNum(), 17.0f,
          "Creating an FloatEntry object and using getValue() should give back the float parameter.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 3
  // Use the FloatEntry object and get the value from using the getOp method.
  @Test
  void testFloatEntryGetOp() {
    assertThrows(BadTypeException.class, () -> floatEntry.getOp(),
        "Calling the getOp() method should throw an Exception.");
  }

}

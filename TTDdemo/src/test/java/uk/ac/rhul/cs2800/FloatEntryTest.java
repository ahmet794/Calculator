package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FloatEntryTest {

  private EntryInt floatEntry;
  private EntryFactory facEntry;

  @BeforeEach
  public void setup() {
    EntryFactory facEntry = new EntryFactory();
    floatEntry = facEntry.createFloatEntry(17.0f);
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

  // 2
  // Use the FloatEntry object and get the value from using the getString method.
  @Test
  void testFloatEntryGetString() {
    assertThrows(BadTypeException.class, () -> floatEntry.getString(),
        "Calling the getString() method should throw an Exception.");
  }

  // 3
  // Use the FloatEntry object and get the value from using the getOp method.
  @Test
  void testFloatEntryGetOp() {
    assertThrows(BadTypeException.class, () -> floatEntry.getOp(),
        "Calling the getOp() method should throw an Exception.");
  }

}

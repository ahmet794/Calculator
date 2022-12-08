package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryFactoryTest {

  private EntryFactory facEntry;

  @BeforeEach
  public void setup() {
    facEntry = new EntryFactory();
  }

  // 1
  // Create an Entry object from EntryFactory class and use the getString method from the Entry
  // class.
  @Test
  void testStringEntryFactory() {
    Entry strEntry = facEntry.createEntry("One");
    try {
      assertEquals(strEntry.getString(), "One",
          "Creating an Entry object using the EntryFactory class should return the string parameter.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 2
  // Create an Entry object from EntryFactory class and use the getValue method from the Entry
  // class.

  @Test
  void testFloatStringEntryFactory() {
    Entry floatEntry = facEntry.createEntry(17.0f);
    try {
      assertEquals(floatEntry.getNum(), 17.0f,
          "Creating an Entry object using the EntryFactory class should return 17.0f.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 3
  // Create an Entry object from EntryFactory class and use the getSymbol method from the Entry
  // class.
  @Test
  void testSymbolEntry() {
    Entry symbolEntry = facEntry.createEntry(Symbol.DIVIDE);
    try {
      assertEquals(symbolEntry.getOp(), Symbol.DIVIDE,
          "Creating an Entry object using the EntryFactory class should return the DIVIDE ENUM.");
    } catch (BadTypeException e) {
      ;
    }
  }

}

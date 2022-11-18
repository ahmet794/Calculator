package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationEntryTest {

  private EntryInt symEntry;
  private EntryFactory facEntry;

  @BeforeEach
  public void setup() {
    symEntry = facEntry.createSymbolEntry(Symbol.DIVIDE);
  }

  // 1
  // Test the OperationEntry class and use the getOp method.
  @Test
  void testOperationEntry() {
    try {
      assertEquals(symEntry.getOp(), Symbol.DIVIDE,
          "Creating an OperationEntry object and calling the class getOp should return the Symbol ENUM that the object is assigned to.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 2
  // Test that the OperationEntry class objects throws BadTypeException for all the methods other
  // than getOp.
  @Test
  void testOperationEntryOtherMethods() {
    assertThrows(BadTypeException.class, () -> symEntry.getNum(),
        "Calling the getNum method in this class should throw an exception.");
    assertThrows(BadTypeException.class, () -> symEntry.getString(),
        "Calling the getString method in this class should throw an exception.");

  }



}

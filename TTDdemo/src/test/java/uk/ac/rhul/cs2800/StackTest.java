package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack s;
  private StrStack strS;
  private Entry element;
  private Entry typeInv;
  private Entry typeSym;
  private Entry typeNum;
  private Entry symbol;
  private Entry string;
  private EntryFactory facEntry;

  // 1
  // Setup to create the object
  @BeforeEach
  public void setup() {
    s = new Stack();
    float value = 17.0f;
    element = new Entry(value);
    typeInv = new Entry(Type.INVALID);
    typeNum = new Entry(Type.NUMBER);
    typeSym = new Entry(Type.SYMBOL);
    symbol = new Entry(Symbol.DIVIDE);
    string = new Entry("String");
    strS = new StrStack();
    facEntry = new EntryFactory();
  }

  // 2
  // Test to create and test size()
  @Test
  void testSize() {
    assertEquals(s.size(), 0, "Test a newly created Stack to see it has 0 value of size.");
  }

  // 3
  // Test to create push(), test push() and size()
  @Test
  void testPush() {
    s.push(element);
    assertEquals(s.size(), 1,
        "Test to see if push works and adds an element to the stack and increases the value of size.");
  }

  // 4
  // Test push() and size() in an extended version
  @Test
  void testPushThreeTimes() {
    s.push(element);
    s.push(element);
    s.push(element);
    assertEquals(s.size(), 3,
        "Test to see if pushing three times to the stack increases the value of size.");
  }

  // 5
  // Test to create pop(), test pop() and size()
  @Test
  void testPop() {
    s.push(element);
    s.pop();
    assertEquals(s.size(), 0,
        "Test to see after pushing one element to the stack, if we use pop if it decreases the value of the size.");

  }

  // 6
  // Test to pop an EmptyStack
  @Test
  void testEmptyStack() {
    assertThrows(EmptyStackException.class, () -> s.pop(), "You can not pop an empty stack.");
  }

  // 7
  // Test to see if push, pop and size works all at the same time
  @Test
  void testPushandPopEmptyStack() {
    s.push(element);
    try {
      assertEquals(s.pop().getValue(), 17.0f,
          "Pushing element and then popping it should give element");
    } catch (BadTypeException e) {
      ;
    }
    assertEquals(s.size(), 0, "Pushing then popping should give the size of the stack 0");
    assertThrows(EmptyStackException.class, () -> s.pop(),
        "Popping a stack with the size value of 0 should give an exception");
  }

  // 8
  // Test to get the value that is returned from pop()
  @Test
  void testPushandPop() {
    s.push(element);
    Entry new_element = new Entry(44.0f);
    s.push(new_element);
    try {
      assertEquals(s.pop().getValue(), 44, "Test to see if pop() returns the popped value");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 9
  // Test top() to get the newest element in the stack
  @Test
  void testTop() {
    s.push(element);
    Entry new_element = new Entry(44.0f);
    s.push(new_element);
    s.pop();
    try {
      assertEquals(s.top().getValue(), 17,
          "After pushing 17, 44 and popping it, top() should return the value of 17");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 10
  // Test top() for an empty stack
  @Test
  void testEmptyStackTop() {
    assertThrows(EmptyStackException.class, () -> s.pop(),
        "Using the pop() method on an empty stack should give EmptyStackException");
  }

  // 11
  // Test and create a new Entry object.
  @Test
  void testEntry() {
    Entry element = new Entry(17.0f);
  }

  // 12
  // Test and create getValue().
  @Test
  void testgetValue() {
    try {
      assertEquals(element.getValue(), 17.0f, "This should give the value of the Entry object");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 13
  // Test pushing a string and calling the getValue() method.
  @Test
  void testPushStringAndgetValue() {
    s.push(string);
    assertThrows(BadTypeException.class, () -> s.top().getValue(),
        "Pushing a string and then using the top() method should give you BadTypeException.");
  }

  // 13
  // Test the getType() after pushing a float.
  @Test
  void testPushTypeNumbergetType() {
    s.push(element);
    try {
      assertEquals(s.pop().getType(), Type.NUMBER,
          "Pushing a float and then popping should give a BadTypeException.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 14
  // Test the getType() after pushing a Type ENUM.
  @Test
  void testPushTypegetType() {
    s.push(typeSym);
    try {
      assertEquals(s.pop().getType(), Type.SYMBOL,
          "Pushing a Type ENUM and popping it should give the pushed Type.");
    } catch (BadTypeException e) {
      ;
    }
  }


  // 15
  // Test the getString() method after pushing a float.
  @Test
  void testPushAndgetString() {
    s.push(element);
    assertThrows(BadTypeException.class, () -> s.pop().getString(),
        "Pushing a float and then popping it and using the method getString() should give a BadTypeException.");
  }

  // 16
  // Test the getSymbol method after pushing a symbol.
  @Test
  void testPushAndgetSymbol() {
    Entry divide = new Entry(Symbol.DIVIDE);
    s.push(divide);
    try {
      assertEquals(s.top().getSymbol(), Symbol.DIVIDE,
          "Pushing a symbol and then using the top() method should give the pushed symbol.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 17
  @Test
  void testPushTypeAndgetSymbol() {
    s.push(typeInv);
    assertThrows(BadTypeException.class, () -> s.top().getSymbol(),
        "After pushing a Type ENUM, using the top() methdod and the getSymbol() method will give you a BadTypeException");
  }

  // 18
  @Test
  void testMultiplePushandGetters() {
    s.push(element);
    s.push(string);
    assertThrows(BadTypeException.class, () -> s.top().getValue(),
        "Pushing a float and a string and then usin the top() method should give BadTypeException");
    s.push(symbol);
    try {
      assertEquals(s.top().getSymbol(), Symbol.DIVIDE,
          "Pushing symbol should give the Symbol ENUM DIVIDE.");
    } catch (BadTypeException e) {
      ;
    }
    s.push(typeInv);
    s.push(typeNum);
    try {
      assertEquals(s.top().getType(), Type.NUMBER,
          "Pushing typeInv and typeNum should give the Type ENUM NUMBER.");
    } catch (BadTypeException e) {
      ;
    }

  }

  // 19
  @Test
  void testStrStackpush() {
    strS.push(string);
  }

  // 20
  @Test
  void testStringEntryFactory() {
    Entry strEntry = facEntry.createStringEntry("One");
    try {
      assertEquals(strEntry.getString(), "One",
          "Creating an Entry object using the EntryFactory class should return the string parameter.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 21
  @Test
  void testFloatStringEntryFactory() {
    Entry floatEntry = facEntry.createFloatEntry(17.0f);
    try {
      assertEquals(floatEntry.getValue(), 17.0f,
          "Creating an Entry object using the EntryFactory class should return 17.0f.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 22
  @Test
  void testSymbolEntry() {
    Entry symbolEntry = facEntry.createSymbolEntry(Symbol.DIVIDE);
    try {
      assertEquals(symbolEntry.getSymbol(), Symbol.DIVIDE,
          "Creating an Entry object using the EntryFactory class should return the DIVIDE ENUM.");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 23
  @Test
  void testStringEntry() {
    StringEntry strEntry = new StringEntry(facEntry.createStringEntry("One"));
    try {
      assertEquals(strEntry.getString(), "One",
          "Creating an StringEntry object and using getString() should give back the string parameter.");
    } catch (BadTypeException e) {
      ;
    }
  }
  




}


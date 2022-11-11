package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {

  private Stack s;
  private Entry element;
  private Entry typeInv;
  private Entry typeSym;
  private Entry typeNum;
  private Entry symbol;
  private Entry string;

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
  }

  // 1
  // Test and create a new Entry object.
  @Test
  void testEntry() {
    Entry element = new Entry(17.0f);
  }

  // 2
  // Test and create getValue().
  @Test
  void testgetValue() {
    try {
      assertEquals(element.getValue(), 17.0f, "This should give the value of the Entry object");
    } catch (BadTypeException e) {
      ;
    }
  }

  // 3
  // Test pushing a string and calling the getValue() method.
  @Test
  void testPushStringAndgetValue() {
    s.push(string);
    assertThrows(BadTypeException.class, () -> s.top().getValue(),
        "Pushing a string and then using the top() method should give you BadTypeException.");
  }

  // 4
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

  // 5
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


  // 6
  // Test the getString() method after pushing a float.
  @Test
  void testPushAndgetString() {
    s.push(element);
    assertThrows(BadTypeException.class, () -> s.pop().getString(),
        "Pushing a float and then popping it and using the method getString() should give a BadTypeException.");
  }

  // 7
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

  // 8
  @Test
  void testPushTypeAndgetSymbol() {
    s.push(typeInv);
    assertThrows(BadTypeException.class, () -> s.top().getSymbol(),
        "After pushing a Type ENUM, using the top() methdod and the getSymbol() method will give you a BadTypeException");
  }

  // 9
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
}

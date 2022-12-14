package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalculatorTest {
  StandardCalculator infix;
  String str;

  @BeforeEach
  void setup() {
    infix = new StandardCalculator();
    str = "1 + 2";
  }

  // Testing addition in the evaluate method.
  @Test
  void testEvaluateAddition() {
    try {
      assertEquals(infix.evaluate(str), 3.0f,
          "Using the infix type and adding 1 to 2 should return 3 as a float.");
      str = "2 + 6";
      assertEquals(infix.evaluate(str), 8.0f,
          "Using the infix type and adding 2 to 6 should return 8 as a float.");
      str = "1 + 3";
      assertEquals(infix.evaluate(str), 4.0f,
          "Using the infix tpye and adding 1 to 3 should return 4 as a float.");
    } catch (InvalidExpression | NumberFormatException | BadTypeException e) {
      ;
    }
  }

  // Testing if parsePostfix works in different kinds infix expressions.
  @Test
  void testparsePostfix() {
    str = "1 + 3";
    try {
      assertEquals(infix.parsePostfix(str), "1 3 + ",
          "Infix expression 1 + 3  should be 1 3 + in postfix type.");
      str = "1 + 4";
      assertEquals(infix.parsePostfix(str), "1 4 + ",
          "Infix expression 1 + 4  should be 1 4 + in postfix type.");
      str = "4 - 1";
      assertEquals(infix.parsePostfix(str), "4 1 - ",
          "Infix expression 4 - 1 should be 4 1 - in postfix type.");
      str = "4 + 1 * 8";
      assertEquals(infix.parsePostfix(str), "4 1 8 * + ",
          "Infix expression 4 + 1 * 8  should be 4 1 8 * + in postfix type.");
      str = "1 * 8 + 4";
      assertEquals(infix.parsePostfix(str), "1 8 4 + * ",
          "Infix expression 1 * 8 + 4  should be 1 8 4 + * in postfix type.");
      str = "( 1 + 3 ) * 4";
      assertEquals(infix.parsePostfix(str), "1 3 + 4 * ",
          "Infix expression ( 1 + 3 ) * 4 should be 1 3 + 4 * in postfix type.");
      str = "( 4 * 5 ) + 5 / 5";
      assertEquals(infix.parsePostfix(str), "4 5 * 5 5 / + ",
          "Infix expression ( 4 * 5 ) + 5 / 5 should be 4 5 * 5 5 / + in postfix type.");
      str = "( 4 * 5 ) + ( 5 / 5 )";
      assertEquals(infix.parsePostfix(str), "4 5 * 5 5 / + ",
          "Infix expression ( 4 * 5 ) + ( 5 / 5 ) should be 4 5 * 5 5 / + in postfix type.");
      str = "( 1 + 3 * 2 ) + ( 1 + 3 * 2 )";
      assertEquals(infix.parsePostfix(str), "1 3 2 * + 1 3 2 * + + ");
      str = "( 5 * ( 6 + 7 ) ) - 2";
      assertEquals(infix.parsePostfix(str), "5 6 7 + * 2 - ");

    } catch (BadTypeException e) {
      ;
    }

  }


  // Testing if ENUM conversion works.
  @Test
  void testEnum() {
    String plus = "+";
    String converted = infix.parseOp(plus);
    Symbol op = Symbol.valueOf(converted);
    assertTrue(op == Symbol.PLUS);
  }


  // Testing more complex expressions that uses different kinds of operators.
  @Test
  void testEvaluateAddMult() {
    try {
      str = "4 + 1 * 8";
      assertEquals(infix.evaluate(str), 12.0f,
          "Multiplying 1 by 8 and then adding 4 should return 12 as a float.");
      str = "1 * 8 + 4";
      assertEquals(infix.evaluate(str), 12.0f,
          "Multiplying 1 by 8 and then adding 4 should return 12 as a float.");
      str = "( 4 * 5 ) + 5 / 5";
      assertEquals(infix.evaluate(str), 21.0f,
          "Multiplying 4 by 5 then dividing 5 by 5 and adding them should return 21 as a float.");
    } catch (NumberFormatException | InvalidExpression | BadTypeException e) {
      ;
    }
  }

  @Test
  void testEvaluateBrackets() throws NumberFormatException, InvalidExpression, BadTypeException {
    str = "( 1 + 3 ) * 4";
    assertEquals(infix.evaluate(str), 16.0f,
        "Adding 1 to 3 and then multiplying by 4 should return 12.0f.");
    str = "( 5 + 3 ) * 4";
    assertEquals(infix.evaluate(str), 32.0f,
        "Adding 5 to 3 and then multiplying by 4 should return 32.0f.");
    str = "( 1 + 3 * 2 ) + ( 1 + 3 * 2 )";
    assertEquals(infix.evaluate(str), 14.0f,
        "Adding 5 to 3 and then multiplying by 4 should return 32.0f.");
    str = "6 / 2 * ( 1 + 2 )";
    assertEquals(infix.evaluate(str), 1.0f,
        "Adding 5 to 3 and then multiplying by 4 should return 32.0f.");
    str = "( 5 * ( 6 + 7 ) ) - 2";
    assertEquals(infix.evaluate(str), 63.0f,
        "Adding 5 to 3 and then multiplying by 4 should return 32.0f.");
    assertEquals(infix.evaluate(str), 63.0f);
  }

  @Test
  void testIsInfix() {
    str = "1 + 3";
    assertEquals(infix.isInfix(str), true, "This is an infix expression.");
    str = "1 3 +";
    assertEquals(infix.isInfix(str), false, "This is a postfix expression.");
    str = "1 + 3 + 4";
    assertEquals(infix.isInfix(str), true, "This is an infix expression.");
    str = "1 3 4 + +";
    assertEquals(infix.isInfix(str), false, "This is a postfix expression.");
    str = "1 3 4 5 + + +";
    assertEquals(infix.isInfix(str), false, "This is a postfix expression.");
    str = "1 3 + 4 *";
    assertEquals(infix.isInfix(str), false, "This is a postfix expression.");
    str = "1 3 2 * + 1 3 2 * + + ";
    assertEquals(infix.isInfix(str), false, "This is a postfix expression.");
    str = "( 1 + 3 * 2 ) + ( 1 + 3 * 2 )";
    assertEquals(infix.isInfix(str), true, "This is an infix expression.");
  }
}
